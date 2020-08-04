#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int N = 0;
    cin >> N;
    //int** time = new int*[N];
    int s;
    int e;
    vector<pair<int, int>> time;
    for (int i = 0; i < N; i++) {
        cin >> s;
        cin >> e;
        time.push_back(make_pair(s, e));
    }
    sort(time.begin(), time.end());
    for (int i = 0; i < N; i++) {
        cout << time[i].first << " " << time[i].second << "\n";
    }

    int startT = 0;
    int endT = 0;
    int term = 0;
    int termNext = 0;
    int count = 0;
    for (int i = 0; i < N; i++) {
        term = time[i].second - time[i].first;
        if (i == N - 1) {
            if (endT <= time[i].first) {
                count++;
            }
            break;
        }
        termNext = time[i + 1].second - time[i + 1].first;
        if (endT <= time[i].first && term <= termNext) {
            startT = time[i].first;
            endT = time[i].second;
            count++;
        }
    }
    cout << count;

    return 0;
}
