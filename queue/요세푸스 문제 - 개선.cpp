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
    int order;
    cin >> order;

    bool flag = true;
    queue<int> q;
    int count = order - 1;
    int temp = 0;
    for (int i = 1; i <= size; i++) {
        q.push(i);
    }
    cout << "<";

    while (q.size() != 1) {
        //���� ���� ���� �ڷ� ����
        for (int k = 0; k < order - 1; k++) {
            q.push(q.front());
            q.pop();
        }
        cout << q.front() << ", ";
        q.pop();
    }
    //������ �ϳ� ������ ��
    cout << q.front() << ">";
    return 0;
}
