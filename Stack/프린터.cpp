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
    //�μ⹰�� ���� �� �� ���� �ݺ�
    while (!q.empty()) {
        curP = q.front();
        q.pop();
        queue<int> temp;
        //���� �տ� �ִ� �μ⹰�� ���� ������ �켱������ ���Ѵ�
        while (!q.empty()) {
            if (curP < q.front())
                isBig = false;
            temp.push(q.front());
            q.pop();
        }
        q = temp;

        //���� �μ⹰�� �켱������ ���� ũ�� location�� �μ⹰�� ��
        if (isBig && !location) {
            answer = order;
            break;
        }
        //location�� ��ġ�� �ƴ����� ���� ū �μ⹰�� ��
        else if (isBig) {
            location--;
            order++;
        }
        //�μ⹰�� �켱������ �и� ��
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
    //ó�� �μ⹰ ��� ������ queue�� �����Ѵ�.
    for (int i = 0; i < priorities.size(); i++) {
        q.push(i);
    }
    int curP;
    //��� ������ ���� �� �� ���� �ݺ�
    while (!q.empty()) {
        curP = q.front();
        q.pop();
        //���� ���� ���� ������ �μ⹰�� �켱������ ���� �켱���� ���� ������ ���� �ڷ� ����
        if (priorities[curP] < *max_element(priorities.begin(), priorities.end())) {
            q.push(curP);
        }
        //���� ���� ���� �μ⹰�� �켱������ ���� Ŭ �ÿ� ���� �� ��Ͽ� �ְ� �ش� �μ⹰�� �켱������ 0���� ����� �μ�Ǿ��ٴ� ���� ǥ���Ѵ�.
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
