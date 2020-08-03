#include <string>
#include <vector>
#include <iostream>
#include <stack>
#include <queue>
#include <deque>
#include <cstring>
using namespace std;


int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int size = 0;
    cin >> size;

    char order[15];
    int key = 0;
    deque<int> d;
    while (size--) {
        cin >> order;
        if (!strcmp(order, "push_front")) {
            cin >> key;
            d.push_front(key);
        }
        else if (!strcmp(order, "push_back")) {
            cin >> key;
            d.push_back(key);
        }
        else if (!strcmp(order, "pop_front")) {
            if (d.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << d.front() << "\n";
            d.pop_front();
        }
        else if (!strcmp(order, "pop_back")) {
            if (d.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << d.back() << "\n";
            d.pop_back();
        }
        else if (!strcmp(order, "size")) {
            cout << d.size() << "\n";
        }
        else if (!strcmp(order, "empty")) {
            cout << d.empty() << "\n";
        }
        else if (!strcmp(order, "front")) {
            if (d.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << d.front() << "\n";
        }
        else if (!strcmp(order, "back")) {
            if (d.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << d.back() << "\n";
        }

    }
    return 0;
}
