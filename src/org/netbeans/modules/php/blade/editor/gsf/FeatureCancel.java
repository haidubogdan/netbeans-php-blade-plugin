package org.netbeans.modules.php.blade.editor.gsf;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhaidu
 */
public class FeatureCancel {
    
    private List<Runnable> cancelActions = new ArrayList<>();
    
    private boolean isCancelled = false;
    
    public synchronized void attachCancelAction(Runnable task) {
        cancelActions.add(task);
    }
    
    public synchronized void cancel() {
        isCancelled = true;
        for(Runnable task : cancelActions) {
            task.run();
        }
    }
        
    public synchronized boolean isCancelled() {
        return isCancelled;
    }
    
}
