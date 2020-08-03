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
        //현재 뽑으려는 숫자의 위치를 찾는다.
        for (int i = 0; i < temp.size(); i++) {
            if (d.front() == curNum) {
                location = i;
                break;
            }
            d.pop_front();
        }
        d = temp;
        //제일 앞의 있는 수가 해당하는 수면 pop
        if (curNum == d.front()) {
            d.pop_front();
            continue;
        }
        //뽑으려는 수의 위치가 중간보다 앞에 있을 시
        else if (location <= d.size() / 2) {
            while (d.front() != curNum) {
                d.push_back(d.front());
                d.pop_front();
                count++;
            }
            d.pop_front();
        }
        //덱의 뒤에 있을 시
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
