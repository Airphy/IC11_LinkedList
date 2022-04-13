public class LinkedList <E>{

    private Node<E> mHead; //cant use E because we need to know who comes next
    private int mSize;

    public LinkedList()
    {
        mHead = null;
        mSize = 0;

    }

    public int size()
    {
        return mSize;
    }

    public boolean add(int index, E element)
    {
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException("index must be >= 0 and less than size");
      //  if(mHead == null)
           // mHead = new Node<E>(element, null);

        if(index == 0)
        {
            mHead = new Node<E>(element, mHead);
        }
        else {

            // Local variable, assign to the node before the index.
            Node<E> temp = mHead;
            // move the temp index-1 times
            for (int i = 0; i < index - 1; i++) {
                temp = temp.mNext;

            }
            temp.mNext = new Node<E>(element, temp.mNext);
        }
        mSize++;
        return true;
    }

    public boolean add(E element)
    {
        return add(mSize, element); //adds at the end
    }

    @Override
    public String toString() {
        String output = "[";
        Node<E> temp = mHead;
        // Keep looping as long as the temp is not null
        while(temp != null)
        {
            output += temp.mData + ((temp.mNext != null) ? ", " : "]");
            temp = temp.mNext;
        }

        return output;
    }

    //nested inner class, the "train cars"
    private class Node<E>
    {
        private E mData;
        private Node<E> mNext;

        private Node(E data, Node<E> next)
        {
            mData = data;
            mNext = next;
        }
        private Node(E data)
        {
            this(data, null);
        }
    }
}
