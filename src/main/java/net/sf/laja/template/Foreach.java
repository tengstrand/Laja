package net.sf.laja.template;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.laja.SyntaxPrinter;
import net.sf.laja.TemplateParser.IBlock;
import net.sf.laja.TemplateParser.ICondition;
import net.sf.laja.TemplateParser.IForeach;
import net.sf.laja.TemplateParser.IListData;
import net.sf.laja.TemplateParser.IMapDataRef;
import net.sf.laja.TemplateParser.IReference;
import net.sf.laja.context.ArrayListAdapter;
import net.sf.laja.context.Context;
import net.sf.laja.context.MapListAdapter;
import net.sf.laja.exception.InterpretationException;
import net.sf.laja.parser.engine2.Index;
import net.sf.laja.parser.engine2.source.Source;
import net.sf.laja.template.data.ListData;
import net.sf.laja.template.data.MapDataRef;
import net.sf.laja.template.data.Reference;

public class Foreach implements IForeach, Generator, Iterable<Object> {
	private int indexInSource;
	private String variableName;
	private Reference reference;
	private ListData listData;
	private MapDataRef mapDataRef;
	private Condition condition;
	private Block block;
	private Context context;
	private Source source;

	public Foreach(Source source, Context context) {
		this.context = context;
		this.source = source;
	}

	public void setBegin(Index begin) {
		indexInSource = begin.getStartIndex();
	}
	
	public void setListData(IListData ilistData) {
		this.listData = (ListData)ilistData;
	}

	public void setMapDataRef(IMapDataRef imapDataRef) {
		this.mapDataRef =(MapDataRef)imapDataRef;
	}

	public void setReference(IReference ireference) {
		this.reference = (Reference)ireference;
	}

	public void setCondition(ICondition icondition) {
		this.condition = (Condition)icondition;
	}
	
	public void setBlock(IBlock iblock) {
		this.block = (Block)iblock;
	}

	public void setVariable(String variable) {
		this.variableName = variable;
	}
	
	public Block getBlock() {
		return block;
	}

	public void setVariableInContext(Object value) {
		context.set(variableName, value);
	}

	/**
	 * Initializes the foreach list and returns the iterator to that list.
	 * 
	 * @return iterator
	 */
	public Iterator<Object> iterator() {
		if (reference == null) {
			if (listData != null) {
				List<Object> foreachList = (List<Object>)listData.evaluate();
				return foreachList.iterator();
			} else {
				return new MapListAdapter((Map)mapDataRef.evaluate()).iterator();
			}
		}
		Object ref = reference.evaluate();
		Iterator<Object> iterator;
		
		if (ref == null) {
			iterator = Collections.emptyList().iterator();
		} else if (ref instanceof Iterator) {
			iterator = (Iterator)ref;
		} else if (ref instanceof Iterable) {
			iterator = ((Iterable)ref).iterator();
		} else if (ref.getClass().isArray()) {
			iterator = new ArrayListAdapter(ref).iterator();
		} else if (ref instanceof Map) {
			iterator = new MapListAdapter((Map)ref).iterator();
		} else {
			throw new InterpretationException(source, indexInSource, "Can not iterate over a " + ref.getClass().getCanonicalName());
		}
		return iterator;
	}

	public Object generate() {
		for (Object value : this) {
			setVariableInContext(value);
			if (condition == null || condition.evaluateBoolean()) {
				block.generate();
			}
		}
		return null;
	}
	
	//    foreach = :begin "#foreach" s "(" varname:variable ws "in" ws listData|mapDataRef|reference s  
    //    ["where" s condition s] ")" skip block end;

	public void print(SyntaxPrinter printer) {
		printer.printWithTabs("#foreach (" + variableName + " in ");
		
		if (listData != null) {
			listData.print(printer);
		} else if (mapDataRef != null) {
			mapDataRef.print(printer);
		} else {
			reference.print(printer);
		}
		
		if (condition != null) {
			printer.print(" where ");
			condition.print(printer);
		}
		printer.print(" ");
		printer.tabForward();
		block.print(printer);
		printer.tabBackward();
		printer.printlnWithTabs("#end");
		
	}

	@Override
	public String toString() {
		return "Foreach{variableName=" + variableName + ", reference=" + reference + ", listData=" + listData +
			", block=" + block + "}";
	}
}
