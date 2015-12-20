#include "LinkedList.h"
#include "iostream"

using namespace  std;

template<typename T>
LinkedList<T>::LinkedList() {};

template<typename T>
LinkedList<T>::~LinkedList() {};

template<typename T>
void LinkedList<T>::insert(T data) {
    Node<T> * newNode = new Node<T>();
    newNode->data = data;
    newNode->next = head;
    head = newNode;
}

template<typename T>
void LinkedList<T>::remove(T data) {
    Node<T> * current = head;
    while (current) {
        if (current->next && current->next->data == data) {
            current->next = current->next->next;
            break;
        }
        current = current->next;
    }
}

template<typename T>
bool LinkedList<T>::isEmpty() {
    return  head == NULL? true : false;
}

template<typename T>
bool LinkedList<T>::exists(T data) {
    Node<T> * current = head;
    while (current) {
        if (current->data == data)
            return true;
        current = current->next;
    }
    return false;
}


template<typename T>
void LinkedList<T>::display() {
    Node<T> * current = head;
    while (current) {
        cout << current->data << ", ";
        current = current->next;
    }
    cout << endl;
}

template<typename T>
void LinkedList<T>::removeDuplicates() {
    Node<T> * current = head;
    while (current) {
        Node<T> * forward_head = current->next;
        Node<T> * forward_tail = current;
        while (forward_head) {
            if (forward_head->data == current->data) {
                // duplicated item found.
                forward_tail->next = forward_head->next;
            }
            else
                forward_tail = forward_tail->next;
            forward_head = forward_head->next;
        }
        current = current->next;
    }
}
