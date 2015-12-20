template<typename T>
struct Node {
    Node<T> * next;
    T data;
};

template<typename T>
class SortedLinkedList
{
private:
    Node<T> * head;
public:
    SortedLinkedList();
    ~SortedLinkedList();
    void insert(T data);
    void remove(T data);
    bool exists(T data);
    unsigned int count();
    bool isEmpty();
    void display();
};