#include <string>
#include <vector>
#include <iostream>
#include <stack>
#include <cstring>
using namespace std;

int main() {
    char str[101];
    stack<char> s;
    cin.getline(str, 101);

    //�� ������ "."�� ������ ������ �ݺ����� �߰��ؾ���.
    bool flag = true;
    for (char a : str) {
        if (a == '[' || a == '(') {
            s.push(a);
        }
        else if (a == ']') {
            if (s.empty() || !(s.top() == '[')) {
                cout << "no" << endl;
                break;
            }
            else {
                s.pop();
            }
        }
        else if (a == ')') {
            if (s.empty() || !(s.top() == '(')) {
                cout << "no" << endl;
                break;
            }
            else {
                s.pop();
            }
        }
        else if (a == '.') {
            flag = false;
        }
        if (flag)
            continue;
        if (s.empty())
            cout << "yes" << endl;
        else
            cout << "no" << endl;
        break;
    }
    return 0;
}
