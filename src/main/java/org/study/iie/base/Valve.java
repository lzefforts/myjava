package org.study.iie.base;

public interface Valve extends IbeExecuteChain {


    /**
     * @return the next Valve in the pipeline containing this Valve, if any.
     */
    Valve getNext();


    /**
     * Set the next Valve in the pipeline containing this Valve.
     *
     * @param valve The new next valve, or <code>null</code> if none
     */
    void setNext(Valve valve);
}
