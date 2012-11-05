package net.sf.laja.example.file.behaviour;

import java.util.List;

import net.sf.laja.example.file.behaviour.text.TextDirectory;
import net.sf.laja.example.file.behaviour.text.TextDirectoryArrayList;

public interface DirectoryList extends List<Directory> {
    TextDirectoryArrayList asTextDirectoryList();
}
