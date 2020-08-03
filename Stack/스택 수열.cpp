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

    stack<int> s;
    queue<char> q;
    int size;
    cin >> size;
    int curNum = 0;
    int stackNum = 0;
    bool flag = true;
    s.push(0);
    //수열에 넣을 숫자를 하나 씩 받는다.
    for (int i = 0; i < size; i++) {
        cin >> curNum;
        //기본적으로 1부터 시작되므로 현재 목표까지 1씩 push한다.
        while (s.top() < curNum) {
            stackNum++;
            s.push(stackNum);
            q.push('+');
        }
        //스택의 제일 위의 숫자가 해당하는 숫자면 pop
        if (s.top() == curNum) {
            s.pop();
            q.push('-');
        }
        //이외의 경우에는 수열을 만들 수 없으므로 break;
        else {
            cout << "NO\n";
            flag = false;
            break;
        }
    }
    if (flag) {
        while (!q.empty()) {
            printf("%c\n", q.front());
            q.pop();
        }
    }
    return 0;
}
