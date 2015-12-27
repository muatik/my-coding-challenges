template<typename T>
struct Node {
    Node<T> * next;
    T data;
};

template<typename T>
class LinkedList
{
private:
    Node<T> * head;
public:
    LinkedList();
    ~LinkedList();
    void insert(T data);
    void remove(T data);
    bool exists(T data);
    Node<T> * getHead();
    unsigned int count();
    bool isEmpty();
    void display();

    void removeDuplicates();
};