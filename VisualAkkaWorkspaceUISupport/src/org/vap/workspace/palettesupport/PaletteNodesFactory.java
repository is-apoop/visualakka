/* 
 */
package org.vap.workspace.palettesupport;

import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Oleg Bantysh
 */
public class PaletteNodesFactory extends ChildFactory<Integer>{

    /**
     *
     * @param list
     * @return
     */
    @Override
    protected boolean createKeys(List<Integer> list) {
        list.add(0);
        return true;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    protected Node createNodeForKey(Integer key) {
        if(key==0){
            Node n = new AbstractNode(Children.create(new NewTabNodesFactory(), true));
            n.setDisplayName("New");
            return n;
        }else{
            return null;
        }
    }
    
}
