package org.netbeans.modules.php.blade.refactoring;

/**
 *
 * @author bhaidu
 */
class BladeRefactoringExtraInfo {

    private boolean refactorAll;

    void setRefactorAll(boolean refactorAll) {
        this.refactorAll = refactorAll;
    }

    public boolean isRefactorAll() {
        return refactorAll;
    }
}
