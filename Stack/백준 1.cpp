#include <string>
#include <vector>
#include <iostream>
#include <stack>
#include <cstring>
using namespace std;


int main() {
    int size;
    cin >> size;
    int bufNum = 0;
    string str;
    stack<int> s;

    for (int i = 0; i < size; i++) {

        cin >> str;
        if (str == "push") {
            cin >> bufNum;
            s.push(bufNum);
        }
        else if (str == "pop") {
            if (!s.empty()) {
                cout << s.top() << endl;
                s.pop();
            }
            else {
                cout << "-1" << endl;
            }
        }
        else if (str == "size") {
            cout << s.size() << endl;
        }
        else if (str == "empty") {
            cout << s.empty() << endl;
        }
        else if (str == "top") {
            if (!s.empty()) {
                cout << s.top() << endl;
            }
            else {
                cout << "-1" << endl;
            }
        }
    }
    return 0;
}
