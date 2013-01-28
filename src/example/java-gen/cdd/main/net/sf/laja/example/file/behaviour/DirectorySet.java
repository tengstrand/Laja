package net.sf.laja.example.file.behaviour;

import java.util.Set;

import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.behaviour.text.TextDirectorySet;
import net.sf.laja.example.file.behaviour.text.TextDirectoryHashSet;

public interface DirectorySet extends Set<Directory> {
    TextDirectorySet asTextDirectorySet();
}
