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
    vector<int> v;

    int term = order - 1;
    int curNum = 0;
    for (int i = 1; i <= size; i++)
        v.push_back(i);
    while (v.size() != 0) {
        if (curNum + term < v.size()) {
            curNum += term;
            cout << v[curNum];
            v.erase(v.begin() + curNum);
        }
        else if (v.size() < order) {
            int temp = v.size() - (curNum - 1);
            int temp2 = order % (v.size() - temp);
            cout << v[temp2];
            v.erase(v.begin() + temp2);
        }
        else {
            int temp = v.size() - (curNum);
            curNum = 0;
            curNum += term - temp;
            cout << v[curNum];
            v.erase(v.begin() + curNum);
        }

    }

    return 0;
}
