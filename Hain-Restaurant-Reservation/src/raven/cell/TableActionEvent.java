package raven.cell;

/**
 *
 * @author RAVEN
 */
public interface TableActionEvent {

    public void increment(int row);

    public void onDelete(int row);

    public void decrement(int row);
    
}
