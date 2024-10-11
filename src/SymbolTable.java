import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    static class SymbolEntry {
        String name;
        String type;

        public SymbolEntry(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    // Map to store symbols
    private final Stack<Map<String, SymbolEntry>> symbols;

    public SymbolTable() {
        symbols = new Stack<>();
        symbols.push(new HashMap<>()); // Initialize with global scope
    }

    // Add a symbol to the symbol table
    public void addSymbol(String name, String type) {
        System.out.println(name);
        if (!symbols.peek().containsKey(name)) {
            symbols.peek().put(name, new SymbolEntry(name, type));
        } else {
            System.err.println("Error: Symbol '" + name + "' already exists in the symbol table.");
        }
    }
    public void enterScope() {
        symbols.push(new HashMap<>());
    }

    public void exitScope() {
        symbols.pop();
    }

    // Get the type of symbol
    public String getType(String name) {
        SymbolEntry entry = symbols.peek().get(name);
        if (entry != null) {
            return entry.type;
        } else {
            System.err.println("Error: Symbol '" + name + "' not found in the symbol table.");
            return null;
        }
    }

    // Check if a symbol exists in the symbol table
    public boolean containsSymbol(String name) {
        return symbols.peek().containsKey(name);
    }
}
