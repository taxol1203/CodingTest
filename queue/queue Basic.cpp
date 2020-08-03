#include <string>
#include <vector>
#include <iostream>
#include <stack>
#include <queue>
#include <cstring>
using namespace std;


int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int size = 0;
    cin >> size;

    char order[7];
    int key = 0;
    queue<int> q;
    while (size--) {
        cin >> order;
        if (!strcmp(order, "push")) {
            cin >> key;
            q.push(key);
        }
        else if (!strcmp(order, "pop")) {
            if (q.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << q.front() << "\n";
            q.pop();
        }
        else if (!strcmp(order, "size")) {
            cout << q.size() << "\n";
        }
        else if (!strcmp(order, "empty")) {
            cout << q.empty() << "\n";
        }
        else if (!strcmp(order, "front")) {
            if (q.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << q.front() << "\n";
        }
        else if (!strcmp(order, "back")) {
            if (q.empty()) {
                cout << "-1\n";
                continue;
            }
            cout << q.back() << "\n";
        }

    }
    return 0;
}
