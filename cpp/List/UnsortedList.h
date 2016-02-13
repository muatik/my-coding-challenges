#ifndef UNSORTEDLIST_H
#define UNSORTEDLIST_H


#define MAX_ITEMS 4

template<typename T>
class UnsortedList
{
private:
    int size = MAX_ITEMS;
    int length;
    int cursorPos;
    T items[MAX_ITEMS];
public:
    UnsortedList();
    bool isFull();
    bool isEmpty();
    void makeEmpty();
    int getLength();
    void insertItem(T item);
    void deleteItem(T item);
    void retrieveItem(T &item, bool &found);
    void resetList();
    void getNextItem(T &item);
};

#endif