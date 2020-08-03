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
    bool flag = true;
    queue<int> q;
    for (int i = 1; i <= size; i++) {
        q.push(i);
    }
    int temp = 0;
    while (q.size() != 1) {
        if (flag) {
            q.pop();
            flag = false;
        }
        else {
            temp = q.front();
            q.pop();
            q.push(temp);
            flag = true;
        }
    }
    cout << q.front();
    return 0;
}
