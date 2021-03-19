public interface IList <T>{
    public void add(T val);
    public T get(int index);
    public boolean contains(T searchItem);
    public int size();
    public boolean remove(T elementToRemove);
}
