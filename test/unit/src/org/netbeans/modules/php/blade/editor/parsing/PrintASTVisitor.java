package org.netbeans.modules.php.blade.editor.parsing;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.netbeans.modules.php.blade.editor.parsing.astnodes.ASTNode;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.Visitor;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.modules.php.blade.editor.parsing.astnodes.*;

public class PrintASTVisitor implements Visitor {

    private StringBuffer buffer;
    private final static String NEW_LINE = "\n";
    private final static String TAB = "    ";
    private int indent;

    @Override
    public void visit(BladeProgram program) {
        XMLPrintNode printNode = new XMLPrintNode(program, "BladeProgram");
        printNode.addChildrenGroup("Statements", program.getStatements());
        printNode.print(this);
    }

    @Override
    public void visit(ASTNode node) {
        // this node shouldn't appear in the result.
        if (node instanceof ASTError || node instanceof ASTErrorExpression) {
            (new XMLPrintNode(node, "ASTError")).print(this);
        } else {
            (new XMLPrintNode(node, "ASTNode")).print(this);
        }
    }

    @Override
    public void visit(DirectiveExpressionBlock node) {
    }

    @Override
    public void visit(BladeYieldStatement node) {
    }

    @Override
    public void visit(BladeExtendsStatement node) {
    }

    @Override
    public void visit(InLinePhp node) {
    }

    @Override
    public void visit(BladeIncludeStatement node) {
    }

    @Override
    public void visit(BladeForeachStatement node) {
    }

    @Override
    public void visit(BladeIfStatement node) {
    }

    @Override
    public void visit(BladeForStatement node) {
    }

    @Override
    public void visit(InLineHtml node) {
    }

    @Override
    public void visit(BladeComment node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(BladeEchoStatement node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(BladeInlineSectionStatement node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(DirectiveWithArgument node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(BladeConditionStatement node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(BladeElseIfStatement node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(InLineBladePhp node) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class XMLPrintNode {

        private class GroupItem {

            private final String groupName;
            private final List<? extends ASTNode> group;

            public GroupItem(String groupName, List<? extends ASTNode> group) {
                this.groupName = groupName;
                this.group = group;
            }

            public List<? extends ASTNode> getGroup() {
                return group;
            }

            public String getGroupName() {
                return groupName;
            }
        }

        private ASTNode node;
        private String name;
        private String[] attributes;
        // <name of children group, childrens>
        private List<GroupItem> childrenGroups;

        public XMLPrintNode(ASTNode node, String name) {
            this(node, name, new String[]{});
        }

        public XMLPrintNode(ASTNode node, String name, String[] attributes) {
            this.node = node;
            this.name = name;
            this.attributes = attributes;
            this.childrenGroups = new ArrayList<GroupItem>();
        }

        public void addChildrenGroup(String groupName, ASTNode[] groupChildren) {
            ArrayList<ASTNode> nodes = new ArrayList<ASTNode>();
            for (int i = 0; i < groupChildren.length; i++) {
                nodes.add(groupChildren[i]);
            }
            addChildrenGroup(groupName, nodes);
        }

        public void addChildrenGroup(String groupName, List<? extends ASTNode> nodes) {
            if (nodes != null) {
                if (this.childrenGroups == null) {
                    this.childrenGroups = new ArrayList<GroupItem>();
                }
                this.childrenGroups.add(new GroupItem(groupName, nodes));
            }
        }

        public void addChildren(List <? extends ASTNode> nodes) {
            if (nodes != null) {
                addChildrenGroup("", nodes);
            }
        }

        public void addChild(ASTNode node) {
            ArrayList<ASTNode> nodes = new ArrayList<ASTNode>();
            nodes.add(node);
            addChildrenGroup("", nodes);
        }

        public void addChild(String name, ASTNode node) {
            ArrayList<ASTNode> nodes = new ArrayList<ASTNode>();
            nodes.add(node);
            addChildrenGroup(name, nodes);
        }

        public void print(Visitor visitor) {
            addIndentation();
            buffer.append("<").append(name);
            addOffsets(node);
            for (int i = 0; i < attributes.length; i++) {
                String attrName = attributes[i];
                String attrValue = attributes[++i];
                if (attrValue == null) {
                    attrValue = "null";
                }
                buffer.append(" ").append(attrName).append("='").append(attrValue).append("'");
            }
            if (childrenGroups.size() > 0) {
                buffer.append(">").append(NEW_LINE);
                indent++;
                for (GroupItem groupItem : childrenGroups) {
                    if (groupItem.getGroupName().length() > 0) {
                        addIndentation();
                        buffer.append("<").append(groupItem.getGroupName()).append(">").append(NEW_LINE);
                        indent++;
                    }
                    if (groupItem.getGroup() != null) {
                        for (ASTNode aSTNode : groupItem.getGroup()) {
                            if (aSTNode != null) {
                                aSTNode.accept(visitor);
                            }
                        }
                    }
                    if (groupItem.getGroupName().length() > 0) {
                        indent--;
                        addIndentation();
                        buffer.append("</").append(groupItem.getGroupName()).append(">").append(NEW_LINE);
                    }
                }
                indent--;
                addIndentation();
                buffer.append("</").append(name).append(">").append(NEW_LINE);
            } else {
                buffer.append("/>").append(NEW_LINE);
            }
        }
    }

    public String printTree(ASTNode node) {
        return printTree(node, 0);
    }

    public String printTree(ASTNode node, int startindent) {
        buffer = new StringBuffer();
        indent = startindent;
        node.accept(this);
        return buffer.toString();
    }

    private void addOffsets(ASTNode node) {
        buffer.append(" start='").append(node.getStartOffset()).append("' end='").append(node.getEndOffset()).append("'");
    }

    protected void addIndentation() {
        for (int i = 0; i < indent; i++) {
            buffer.append(TAB);
        }
    }

    private void addNodeDescription(String name, ASTNode node, boolean newline) {
        addIndentation();
        buffer.append(name);
        addOffsets(node);
        if (newline) {
            buffer.append(NEW_LINE);
        }
    }

    //blade
    public void visit(BladeSectionStatement node) {
        XMLPrintNode printNode = new XMLPrintNode(node, "BladeSection", new String[]{"block"});
        printNode.addChild(node.getLabel());
        printNode.print(this);
    }

}
