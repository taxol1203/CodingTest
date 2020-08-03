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
    queue<int> save;
    queue<int> result;
    int count = order - 1;
    int temp = 0;
    for (int i = 1; i <= size; i++) {
        q.push(i);
    }
    while (size--) {
        while (count--) {
            if (q.empty()) {
                q = save;
                while (!save.empty())
                {
                    save.pop();
                }
            }

            save.push(q.front());
            q.pop();
        }
        if (q.empty()) {
            q = save;
            while (!save.empty())
            {
                save.pop();
            }
        }
        result.push(q.front());
        q.pop();
        count = order - 1;
    }

    cout << "<";
    int temp1 = result.size() - 1;
    while (temp1--) {
        cout << result.front() << ", ";
        result.pop();
    }
    cout << result.front() << ">";
    return 0;
}
