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
    //������ ���� ���ڸ� �ϳ� �� �޴´�.
    for (int i = 0; i < size; i++) {
        cin >> curNum;
        //�⺻������ 1���� ���۵ǹǷ� ���� ��ǥ���� 1�� push�Ѵ�.
        while (s.top() < curNum) {
            stackNum++;
            s.push(stackNum);
            q.push('+');
        }
        //������ ���� ���� ���ڰ� �ش��ϴ� ���ڸ� pop
        if (s.top() == curNum) {
            s.pop();
            q.push('-');
        }
        //�̿��� ��쿡�� ������ ���� �� �����Ƿ� break;
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
