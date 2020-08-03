#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<int> q;
    for (int i = 0; i < priorities.size(); i++)
        q.push(priorities[i]);
    int curP;
    int order = 1;
    bool isBig = true;
    //인쇄물이 없어 질 때 까지 반복
    while (!q.empty()) {
        curP = q.front();
        q.pop();
        queue<int> temp;
        //제일 앞에 있는 인쇄물을 빼고 나머지 우선순위와 비교한다
        while (!q.empty()) {
            if (curP < q.front())
                isBig = false;
            temp.push(q.front());
            q.pop();
        }
        q = temp;

        //비교한 인쇄물의 우선순위가 제일 크고 location인 인쇄물일 시
        if (isBig && !location) {
            answer = order;
            break;
        }
        //location의 위치는 아니지만 제일 큰 인쇄물일 시
        else if (isBig) {
            location--;
            order++;
        }
        //인쇄물이 우선순위에 밀릴 시
        else {
            q.push(curP);
            if (!location) {
                location += q.size() - 1;
            }
            else
                location--;
        }
        isBig = true;
    }

    return answer;
}


int better_solution(vector<int> priorities, int location) {
    int answer = 0;
    queue<int> q;
    vector<int> sorted;
    //처음 인쇄물 대기 순서를 queue로 저장한다.
    for (int i = 0; i < priorities.size(); i++) {
        q.push(i);
    }
    int curP;
    //대기 순서가 없어 질 때 까지 반복
    while (!q.empty()) {
        curP = q.front();
        q.pop();
        //현재 제일 앞의 순서의 인쇄물의 우선순위가 뒤의 우선순위 보다 작으면 제일 뒤로 보냄
        if (priorities[curP] < *max_element(priorities.begin(), priorities.end())) {
            q.push(curP);
        }
        //현재 제일 앞의 인쇄물의 우선순위가 제일 클 시에 정렬 된 목록에 넣고 해당 인쇄물의 우선순위를 0으로 만들어 인쇄되었다는 것을 표시한다.
        else{
            sorted.push_back(curP);
            priorities[curP] = 0;
        }
    }
    for (int i = 0; i < sorted.size(); i++) {
        if (sorted[i] == location) {
            return i + 1;
        }
    }

    return answer;
}


int main() {
    vector<int> returnVector;
    int val = solution({ 2, 1, 3, 2 }, 2);

    cout << val;

    //for (int i = 0; i < returnVector.size(); i++)
    //    cout << returnVector.at(i) << " ";
    return 0;
}
