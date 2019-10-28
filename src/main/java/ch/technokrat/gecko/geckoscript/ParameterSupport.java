/*  This file is part of GeckoCIRCUITS. Copyright (C) ETH Zurich, Gecko-Simulations GmbH
 *
 *  GeckoCIRCUITS is free software: you can redistribute it and/or modify it under 
 *  the terms of the GNU General Public License as published by the Free Software 
 *  Foundation, either version 3 of the License, or (at your option) any later version.
 *
 *  GeckoCIRCUITS is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE.  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with
 *  GeckoCIRCUITS.  If not, see <http://www.gnu.org/licenses/>.
 */
package ch.technokrat.gecko.geckoscript;

import ch.technokrat.gecko.Documentation;
import ch.technokrat.gecko.geckocircuits.allg.UserParameter;
import ch.technokrat.gecko.geckocircuits.circuit.AbstractBlockInterface;
import ch.technokrat.gecko.geckocircuits.circuit.AbstractTypeInfo;
import ch.technokrat.gecko.geckocircuits.control.Operationable;
import ch.technokrat.gecko.geckocircuits.control.RegelBlock;
import java.awt.Component;
import java.awt.Font;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicTreeUI;

public class ParameterSupport extends javax.swing.JFrame {

    private final List<List<AbstractBlockInterface>> _allComponents;
    private final DefaultListModel _availableParametersModel = new DefaultListModel();
    private final DefaultListModel _selectBlockTypeModel = new DefaultListModel();
    private final DefaultListModel _availableBlocksModel;

    public ParameterSupport(final SimulationAccess circuit) {
        super();
        _allComponents = Collections.unmodifiableList(circuit.getElementsSorted());
        initComponents();
        _listAvailableBlocks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        _listAvailableBlocks.setEnabled(false);
        _listSelectBlockType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        _listSelectBlockType.setModel(_selectBlockTypeModel);

        _listSelectBlockType.setCellRenderer(new DefaultListCellRenderer() {
            private final DefaultListCellRenderer _wrapped = new DefaultListCellRenderer();

            @Override
            public Component getListCellRendererComponent(
                    final JList list,
                    final Object value,
                    final int index,
                    final boolean isSelected,
                    final boolean cellHasFocus) {
                AbstractTypeInfo elementType = (AbstractTypeInfo) value;
                String fixedID = elementType._fixedIDString;
                String description = elementType._typeDescriptionVerbose.getTranslation();
                String type = fixedID + " (" + description + ")";
                return _wrapped.getListCellRendererComponent(list, type, index, isSelected, cellHasFocus);
            }
        });

        
        _listAvailableParameters.setModel(_availableParametersModel);
        _availableBlocksModel = new DefaultListModel();
        _listAvailableBlocks.setModel(_availableBlocksModel);       
        _listAvailableParameters.setCellRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(
                    final JList list,
                    final Object value,
                    final int index,
                    final boolean isSelected,
                    final boolean cellHasFocus) {
                String parameterString = value.toString();
                final String[] substrings = parameterString.split("\t");
                if (substrings.length == 2) {
                    parameterString = substrings[0];
                    for (int i = 0; i < 15 - substrings[0].length(); i++) {
                        parameterString = parameterString + " ";
                    }
                    parameterString = parameterString + substrings[1];
                } 
                setFont(new Font("Courier New", Font.BOLD, 14));
                setText(parameterString);
                return this;

            }
        });

        fillListsInitial();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        _listAvailableBlocks = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        _listSelectBlockType = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        _listAvailableParameters = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GeckoSCRIPT - Available Parameters & Outputs");

        jLabel1.setText("Select block type:");

        jLabel2.setText("Available blocks (names):");

        _listAvailableBlocks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        _listAvailableBlocks.setFocusable(false);
        jScrollPane3.setViewportView(_listAvailableBlocks);

        _listSelectBlockType.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        _listSelectBlockType.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                _listSelectBlockTypeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(_listSelectBlockType);

        jLabel3.setText("Accessible Parameters:");

        _listAvailableParameters.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(_listAvailableParameters);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(229, 229, 229))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Available blocks and parameters", jPanel1);

        jLabel4.setText("Description:");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Below is a listing of the availabe blocks for manipulation via GeckoSCRIPT in the currently open model along with their accessible parameters.\n\nFor control blocks, available outputs are also listed.\n\nThe objects are sorted by type, with the parameter (and output) names listed  long with the block names. In brackets are given descriptions of the parameters and, if applicable, their units.\n\nThe block names and parameter/output names listed here are to be used when manipulating the model blocks using the GeckoSCRIPT functions.\n\nFor control blocks with several outputs, the output that is to be accessed must be given by name using the getOutput(elementName,outputName) function. For control blocks with a single output, the getOutput(elementName) function may be used.\nFor control blocks with variable number of outputs (e.g. Java Block), the getOutput(elementName) function may be used as well. If such a block has more than one output, this function will return the value of the first one.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Description", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _listSelectBlockTypeValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event__listSelectBlockTypeValueChanged
        final AbstractTypeInfo selectedType = (AbstractTypeInfo) (_listSelectBlockType.getSelectedValue());
        updateAccessibleParameters(selectedType);
    }//GEN-LAST:event__listSelectBlockTypeValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList _listAvailableBlocks;
    private javax.swing.JList _listAvailableParameters;
    private javax.swing.JList _listSelectBlockType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void fillListsInitial() {
        _selectBlockTypeModel.clear();
        _availableParametersModel.clear();
        _availableBlocksModel.clear();

        for (List<AbstractBlockInterface> currentList : _allComponents) {
            _selectBlockTypeModel.addElement(currentList.get(0).getTypeInfo());
            for (AbstractBlockInterface elem : currentList) {
                if (_listAvailableBlocks.getSelectedValue() == elem.getTypeEnum()) {
                    _availableBlocksModel.addElement(elem);
                }
            }
        }
        
        for (List<AbstractBlockInterface> list : _allComponents) {
            for (AbstractBlockInterface block : list) {
                _availableBlocksModel.addElement(block);
            }
        }
    }

    private void updateAccessibleParameters(final AbstractTypeInfo selectedType) {                        
        _availableBlocksModel.clear();
        _availableParametersModel.clear();

        for (List<AbstractBlockInterface> currentList : _allComponents) {
            AbstractBlockInterface firstElement = currentList.get(0);
            final List<UserParameter<? extends Object>> currentElemTypeFields = firstElement.getRegisteredParameters();
            
            
            if (currentList.get(0).getTypeInfo().equals(selectedType)) {
                for (AbstractBlockInterface insert : currentList) {
                    _availableBlocksModel.addElement(insert);
                }
                _availableParametersModel.addElement("-- PARAMETERS --");
                if (currentElemTypeFields.isEmpty()) {
                    _availableParametersModel.addElement("No parameters available");
                } else {
                    for (UserParameter parameter : currentElemTypeFields) {
                        if(!(parameter.getValue() instanceof String)) { // string parameters cannot be accessed!
                            _availableParametersModel.addElement(parameter.getShortName() + "\t(" + parameter.getLongName() + ")");
                        }                        
                    }
                }

                if (firstElement instanceof RegelBlock) {
                    final List<String[]> currentElemTypeOutputs = ((RegelBlock) firstElement).getOutputs();
                    _availableParametersModel.addElement("-- OUTPUT --");
                    if (currentElemTypeOutputs != null) {
                        for (String[] output : currentElemTypeOutputs) {
                            _availableParametersModel.addElement(output[0] + "\t(" + output[1] + ")");
                        }
                    } else {
                        _availableParametersModel.addElement("No output available");
                    }
                }
                
                if (firstElement instanceof Operationable) {
                    List<Operationable.OperationInterface> ops = ((Operationable) firstElement).getOperationEnumInterfaces();
                    _availableParametersModel.addElement("-- POSSIBLE OPERATIONS (see method \"doOperation\") --");
                    for(Operationable.OperationInterface op : ops) {
                        String opName = op.toString();                        
                        String opDoc = op.getDocumentationString();                        
                        _availableParametersModel.addElement("Operation name: \"" + opName + "\"  ( " + opDoc + " )");
                    }
                    
                    _availableParametersModel.addElement("Operation name: \"setTextFieldPosition\" ( Example: doOperation(\"R.1\", \"setTextFieldPosition\", new double[]{2.1, 1.5});");
                }
                
                
            }
        }
    }
}