#include <iostream>
#include "UnsortedList.cpp"
using namespace std;


int main(int argc, char const *argv[]) {
    UnsortedList<int> us;
    us.insertItem(4);
    us.insertItem(1);
    us.insertItem(3);
    us.insertItem(3);
    int a;
    for (int i = 0; i < us.getLength(); ++i)
    {
        us.getNextItem(a);
        cout << a << endl;
    }
    return 0;
}