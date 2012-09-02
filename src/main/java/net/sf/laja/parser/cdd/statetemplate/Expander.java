package net.sf.laja.parser.cdd.statetemplate;

import java.util.*;

public class Expander {
    public boolean cyclic = false;
    public String cyclicMessage;
    public Imports importsResult;
    public List<Attribute> attributesResult;
    private List<StateTemplate> stateTemplates = new ArrayList<StateTemplate>();
    private Map<String, StateTemplate> stateTemplateMap;

    public void add(StateTemplate stateTemplate) {
        stateTemplates.add(stateTemplate);
    }

    /**
     * Adds expanded attributes and imports from expanded attributes, to all state templates.
     *
     * @param errors if any cyclic dependency is encountered a message are added to 'errors'.
     */
    public void expand(StateTemplateErrors errors) {
        Map<String, ExpansionResult> stateClassMap = calculateExpansion();

        if (cyclic) {
            errors.addMessage(cyclicMessage);
            return;
        }
        // Update state templates with the expanded attributes and imports.
        for (StateTemplate stateTemplate : stateTemplates) {
            ExpansionResult expandedResult = stateClassMap.get(stateTemplate.stateClass);
            stateTemplate.setAttributes(expandedResult.attributes);
            for (Importstatement importstatement : expandedResult.imports) {
                stateTemplate.imports.addImportIfNotExists(importstatement);
            }
        }
    }

    /**
     * Goes through all state templates and calculates new expanded attributes and
     * possible needed imports for every state template.
     *
     * @return state templates with attributes and imports.
     */
    public Map<String, ExpansionResult> calculateExpansion() {
        Map<String, ExpansionResult> stateClassMap = new LinkedHashMap<String, ExpansionResult>();
        
        for (StateTemplate stateTemplate : stateTemplates) {
            importsResult = new Imports();
            attributesResult = new ArrayList<Attribute>();
            List<String> expandingTypes = new ArrayList<String>();

            expand(stateTemplate.stateClass, expandingTypes);
            stateClassMap.put(stateTemplate.stateClass, new ExpansionResult(attributesResult, importsResult));
        }
        calculateAllExpandedTypes();

        return stateClassMap;
    }

    private void calculateAllExpandedTypes() {
        stateTemplateMap = new HashMap<String,StateTemplate>();
        for (StateTemplate stateTemplate : stateTemplates) {
            stateTemplateMap.put(stateTemplate.classname, stateTemplate);
        }
        for (StateTemplate stateTemplate : stateTemplates) {
            stateTemplate.allConvertMethods.addAll(stateTemplate.convertMethods);
            for (ExpandedType expandedType : stateTemplate.expandedTypes) {
                addExpandedType(expandedType, stateTemplate.allExpandedTypes, stateTemplate.allConvertMethods, stateTemplate.allImports);
            }
        }
    }

    private void addExpandedType(ExpandedType expandedType, Set<ExpandedType> allExpandedTypes, Set<ConvertMethod> allConvertMethods, Imports allImports) {
        if (!allExpandedTypes.contains(expandedType)) {
            allExpandedTypes.add(expandedType);
            StateTemplate stateTemplate = stateTemplateMap.get(expandedType.type);
            allConvertMethods.addAll(stateTemplate.convertMethods);
            allImports.addImports(stateTemplate.imports);

            for (ExpandedType expType : stateTemplate.expandedTypes) {
                addExpandedType(expType, allExpandedTypes, allConvertMethods, allImports);
            }
        }
    }

    private void expand(String type, List<String> expandingTypes) {
        if (cyclic) {
            return;
        }
        if (expandingTypes.contains(type)) {
            cyclicMessage = "Cyclic references: ";
            String separator = "";
            for (String expandingType : expandingTypes) {
                cyclicMessage += separator + expandingType;
                separator = " > ";
            }
            cyclicMessage += separator + type;
            cyclic = true;
            return;
        }
        expandingTypes.add(type);
        StateTemplate stateTemplate = findStateTemplate(type);

        if (stateTemplate != null) {
            for (Attribute attribute : stateTemplate.attributes) {
                if (attribute.isExpand) {
                    addExpandedImports(stateTemplate, attribute);
                    expand(attribute.type, expandingTypes);
                } else {
                    if (attribute.isObject() && !attribute.isExpand) {
                        addImportForStandardObjects(attribute.type, stateTemplate.imports);
                    }
                    if (!attributesResult.contains(attribute)) {
                        attributesResult.add(attribute);
                    } else {
                        Attribute existingAttribute = attributesResult.get(attributesResult.indexOf(attribute));
                        if (existingAttribute.isOptional && attribute.isMandatory) {
                            // Replace the attribute to the one that is mandatory.
                            attributesResult.remove(attribute);
                            attributesResult.add(attribute);
                        }
                    }
                }
            }
            addImportsForViews(stateTemplate);
        }
    }

    private void addImportsForViews(StateTemplate stateTemplate) {
        for (StateMethod method : stateTemplate.stateMethods) {
            StateTemplate viewTemplate = findStateTemplate(method.classname + "State");
            if (viewTemplate != null) {
                for (Importstatement importstatement : viewTemplate.imports) {
                    importsResult.addImportIfNotExists(importstatement);
                }
            }
        }
    }

    private void addExpandedImports(StateTemplate stateTemplate, Attribute attribute) {
        StateTemplate expandedTemplate = findStateTemplate(attribute.type);
        if (expandedTemplate != null) {
            String type = attribute.isState ? attribute.cleanedStateType : attribute.type;
            stateTemplate.expandedTypes.add(new ExpandedType(attribute.variable, type, expandedTemplate.packagename + "." + type));
        }
    }

    private void addImportForStandardObjects(String type, Imports imports) {
        for (Importstatement importstatement : imports) {
            if (importstatement.endsWithType(type)) {
                importsResult.addImportstatement(importstatement);
            }
        }
    }
    
    private StateTemplate findStateTemplate(String type) {
        for (StateTemplate stateTemplate : stateTemplates) {
            if (type.equals(stateTemplate.stateClass)) {
                return stateTemplate;
            }
        }
        return null;
    }
    
    public class ExpansionResult {
        public List<Attribute> attributes;
        public Imports imports;

        public ExpansionResult(List<Attribute> attributes, Imports imports) {
            this.attributes = attributes;
            this.imports = imports;
        }

        @Override
        public String toString() {
            return "ExpansionResult{" +
                    "attributes=" + attributes +
                    ", imports=" + imports +
                    '}';
        }
    }
}
