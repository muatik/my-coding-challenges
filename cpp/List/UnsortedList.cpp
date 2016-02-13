#include "UnsortedList.h"
#include "stdexcept"
using namespace std;

template<typename T>
UnsortedList<T>::UnsortedList() {
    makeEmpty();
    resetList();
}

template<typename T>
bool UnsortedList<T>::isFull() {
    return length == size;
}

template<typename T>
bool UnsortedList<T>::isEmpty() {
    return length == 0;
}

template<typename T>
void UnsortedList<T>::makeEmpty() {
    length = 0;
}

template<typename T>
int UnsortedList<T>::getLength() {
    return length;
}

template<typename T>
void UnsortedList<T>::insertItem(T item) {
    if (isFull())
        throw overflow_error("list is full.");
    items[length] = item;
    length++;
}

template<typename T>
void UnsortedList<T>::deleteItem(T item) {
    int position = -1;
    for (int i = 0; i < length; ++i)
    {
        if (items[i] == item) {
            position = i;
            break;
        }
    }

    if (position == -1)
        return; // item to be deleted not found

    for (int i = position; i < length - 1 ; ++i)
    {
        items[i] = items[position + 1];
    }
    items[length - 1] = NULL;
    length--;
}

template<typename T>
void UnsortedList<T>::resetList() {
    cursorPos = 0;
}

template<typename T>
void UnsortedList<T>::getNextItem(T &item) {
    if (cursorPos < length) {
        item = items[cursorPos++];
    }
}