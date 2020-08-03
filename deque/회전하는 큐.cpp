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

    int N = 0;
    cin >> N;

    int M;
    cin >> M;

    deque<int> d;

    for (int i = 1; i <= N; i++) {
        d.push_back(i);
    }
    int curNum;
    int count = 0;
    int location = 0;
    deque<int> temp;
    while (M--) {
        cin >> curNum;
        temp = d;
        //���� �������� ������ ��ġ�� ã�´�.
        for (int i = 0; i < temp.size(); i++) {
            if (d.front() == curNum) {
                location = i;
                break;
            }
            d.pop_front();
        }
        d = temp;
        //���� ���� �ִ� ���� �ش��ϴ� ���� pop
        if (curNum == d.front()) {
            d.pop_front();
            continue;
        }
        //�������� ���� ��ġ�� �߰����� �տ� ���� ��
        else if (location <= d.size() / 2) {
            while (d.front() != curNum) {
                d.push_back(d.front());
                d.pop_front();
                count++;
            }
            d.pop_front();
        }
        //���� �ڿ� ���� ��
        else {
            while (d.front() != curNum) {
                d.push_front(d.back());
                d.pop_back();
                count++;
            }
            d.pop_front();
        }
    }
    cout << count;
    return 0;
}
