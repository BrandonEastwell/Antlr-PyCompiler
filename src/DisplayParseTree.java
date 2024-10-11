import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class DisplayParseTree {
    public static void printTree(ParseTree tree) {
        JFrame frame = new JFrame("Parse Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Parse Tree");
        buildTree(rootNode, tree);

        JTree jTree = new JTree(rootNode);
        JScrollPane scrollPane = new JScrollPane(jTree);
        scrollPane.setPreferredSize(new Dimension(400, 600));

        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }

    private static void buildTree(DefaultMutableTreeNode parent, ParseTree tree) {
        //checks to see if the parse tree is an instance of RuleNode (represents parser rule) or TerminalNode (represents a token)
        //due to different behaviour in accessing child nodes where TerminalNodes do not have children
        if (tree instanceof RuleNode) {
            RuleNode ruleNode = (RuleNode) tree;
            for (int i = 0; i < ruleNode.getChildCount(); i++) {
                ParseTree child = ruleNode.getChild(i);
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(getNodeText(child));
                parent.add(childNode);
                buildTree(childNode, child);
            }
        } else if (tree instanceof TerminalNode) {
            DefaultMutableTreeNode terminalNode = new DefaultMutableTreeNode(getNodeText(tree));
            parent.add(terminalNode);
        }
    }
    private static String getNodeText(ParseTree tree) {
        if (tree instanceof RuleContext) {
            return ((RuleContext) tree).getRuleIndex() + ": " + PyExprParser.ruleNames[((RuleContext) tree).getRuleIndex()];
        } else if (tree instanceof TerminalNode) {
            return ((TerminalNode) tree).getSymbol().getText();
        } else {
            return "unrecognised";
        }
    }
}
