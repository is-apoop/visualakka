/* 
 */
package org.vap.filetypesupport;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.core.spi.multiview.CloseOperationState;
import org.netbeans.core.spi.multiview.MultiViewElement;
import org.netbeans.core.spi.multiview.MultiViewElementCallback;
import org.netbeans.spi.palette.PaletteActions;
import org.netbeans.spi.palette.PaletteController;
import org.netbeans.spi.palette.PaletteFactory;
import org.openide.awt.UndoRedo;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.ExplorerUtils;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.Lookups;
import org.openide.util.lookup.ProxyLookup;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.vap.workspace.StatesViewTopComponent;
import org.vap.workspace.UnitsPaletteTopComponent;
import org.vap.workspace.WorkspaceScene;
import org.vap.workspace.palettesupport.PaletteNodesFactory;

/**
 *
 * @author Олег
 */
@MultiViewElement.Registration(
        displayName = "#LBL_VisualAkkaUnit_VISUAL",
        iconBase = "org/vap/filetypesupport/vfl16.png",
        mimeType = "text/x-vau",
        persistenceType = TopComponent.PERSISTENCE_NEVER,
        preferredID = "VisualAkkaUnitVisual",
        position = 2000
)
@Messages("LBL_VisualAkkaUnit_VISUAL=Visual")
public final class VisualAkkaUnitVisualElement extends TopComponent implements MultiViewElement, ExplorerManager.Provider {

    private VisualAkkaUnitDataObject obj;
    private JToolBar toolbar;
    private Lookup lookup;
    private transient MultiViewElementCallback callback;
    private WorkspaceScene scene;
    private JScrollPane jsp = new JScrollPane();
    private PaletteController paletteController;
    private ExplorerManager em = new ExplorerManager();
    private TopComponent statesTC;
    
    /**
     *
     * @param lkp
     */
    public VisualAkkaUnitVisualElement(Lookup lkp) {
        obj = lkp.lookup(VisualAkkaUnitDataObject.class);
        scene = lkp.lookup(WorkspaceScene.class);
        scene.load();
        //It should do smth with validation error;
        scene.validate();
        lookup = new ProxyLookup(lkp, Lookups.singleton(new VisualAkkaUnitNavigatorLookupHint()));
        assert obj != null;
        initComponents();
        setLayout(new BorderLayout());
        JComponent component;
        if (scene.getView() == null) {
            component = scene.createView();
            scene.validate();
        } else {
            component = scene.getView();
        }
        jsp.setViewportView(component);
        add(jsp, BorderLayout.CENTER);
        Node r = new AbstractNode(Children.create(new PaletteNodesFactory(), false));
        PaletteActions a = new MyPaletteActions();
        paletteController = PaletteFactory.createPalette(r, a);
        associateLookup(ExplorerUtils.createLookup(getExplorerManager(), getActionMap()));
        toolbar = scene.getToolbar();
        scene.setRelatedTC(this);
        scene.setEM(em);
        //statesTC = new StatesViewTopComponent(lookup);
    }

    /**
     *
     * @return
     */
    @Override
    public ExplorerManager getExplorerManager() {
        return em;
    }

//    public void setActiveNode(Node n) {
//        AbstractNode rootn = new AbstractNode(Children.create(new PropertyNodeFactory(n), true));
//        em.setRootContext(rootn);
//        try {
//            em.setSelectedNodes(new Node[]{n});
//        } catch (PropertyVetoException ex) {
//            Exceptions.printStackTrace(ex);
//        }
//        Node[] test = em.getSelectedNodes();
//    }

    private static final class MyPaletteActions extends PaletteActions {

        @Override
        public Action[] getImportActions() {
            return new Action[]{};
        }

        @Override
        public Action[] getCustomPaletteActions() {
            return new Action[]{};
        }

        @Override
        public Action[] getCustomCategoryActions(Lookup arg0) {
            return new Action[]{};
        }

        @Override
        public Action[] getCustomItemActions(Lookup arg0) {
            return new Action[]{};
        }

        @Override
        public Action getPreferredAction(Lookup arg0) {
            return new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
            };
        }
    }

    @Override
    public String getName() {
        return "VisualAkkaUnitVisualElement";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @return
     */
        @Override
    public JComponent getVisualRepresentation() {
        return this;
    }

    /**
     *
     * @return
     */
    @Override
    public JComponent getToolbarRepresentation() {
        return toolbar;
    }

    /**
     *
     * @return
     */
    @Override
    public Action[] getActions() {
        return new Action[0];
    }

    /**
     *
     * @return
     */
    @Override
    public Lookup getLookup() {
        //return obj.getLookup();
        return new ProxyLookup(obj.getLookup(), Lookups.fixed(paletteController, this));
    }

    /**
     *
     */
    @Override
    public void componentOpened() {
        WindowManager.getDefault().findTopComponent("properties").open();
        //statesTC.open();
        try{
        UnitsPaletteTopComponent uptc = (UnitsPaletteTopComponent)WindowManager.getDefault().findTopComponent("UnitsPaletteTopComponent");
        uptc.open();
        uptc.UpdateWindow(FileOwnerQuery.getOwner(obj.getPrimaryFile()));
        }catch(Exception e){}
        try{
            StatesViewTopComponent svtc = (StatesViewTopComponent)WindowManager.getDefault().findTopComponent("StatesViewTopComponent");
            svtc.open();
            svtc.UpdateWindow(scene);
        }catch(Exception e){}
        
        if(scene.satteliteView!=null){
            scene.isInitialized = true;
            scene.satteliteView.pane.setViewportView(scene.createSatelliteView());
        }
    }

    /**
     *
     */
    @Override
    public void componentClosed() {
        //WindowManager.getDefault().findTopComponent("UnitsViewTopComponent").close();
    }

    /**
     *
     */
    @Override
    public void componentShowing() {
    }

    /**
     *
     */
    @Override
    public void componentHidden() {
    }

    /**
     *
     */
    @Override
    public void componentActivated() {
        WindowManager.getDefault().findTopComponent("properties").open();
        //statesTC.open();
        try{
        UnitsPaletteTopComponent uptc = (UnitsPaletteTopComponent)WindowManager.getDefault().findTopComponent("UnitsPaletteTopComponent");
        uptc.open();
        uptc.UpdateWindow(FileOwnerQuery.getOwner(obj.getPrimaryFile()));
        }catch(Exception e){}
        try{
            StatesViewTopComponent svtc = (StatesViewTopComponent)WindowManager.getDefault().findTopComponent("StatesViewTopComponent");
            svtc.open();
            svtc.UpdateWindow(scene);
        }catch(Exception e){}
        if(scene.satteliteView!=null){
            scene.isInitialized = true;
            scene.satteliteView.pane.setViewportView(scene.createSatelliteView());
        }
    }

    /**
     *
     */
    @Override
    public void componentDeactivated() {
    }

    /**
     *
     * @return
     */
    @Override
    public UndoRedo getUndoRedo() {
        return scene.getUndoRedo();
    }

    /**
     *
     * @param callback
     */
    @Override
    public void setMultiViewCallback(MultiViewElementCallback callback) {
        this.callback = callback;
    }

    /**
     *
     * @return
     */
    @Override
    public CloseOperationState canCloseElement() {
        return CloseOperationState.STATE_OK;
    }

}
