#include <fstream>
#include <iomanip>
#include <vector>
#include <algorithm>
#include<iostream>

using namespace std;

class Task {
public:

    void solve() {
        read_input();
        print_output(get_result());
    }

private:
    int n, k;
    vector<int> v;


    void read_input() {
        ifstream fin("p2.in");
        fin >> n >> k;

        for (int i = 0, e; i < n; i++) {
            fin >> e;
            v.push_back(e);

        }
        fin.close();
    }

    int get_result() {

        if (n <= k) {
            return 0;
        }

        long int dp[n];
        int count = 1, eliminare = 0;
        sort(v.rbegin(), v.rend());
        for (int j = 0; j < n; j++) {
            cout << v[j] << " ";
        }

        dp[0] = v[0];
        
        for (int j = 1; j < n; j++) {

            if (count == 0) {
                dp[j] = dp[j - 1] + v[j];
                count = 1;
            } else {
                for (; eliminare < k; eliminare++) {
                    if (dp[j - 1] == v[j]) {
                        dp[j] = 0;
                        count = 0;
                        break;
                    } else if (v[j] == v[j + 1]) {
                        dp[j] = dp[j-1];

                       j++;
                        break;
                    } else {
                        dp[j] = dp[j - 1];
                        j++;

                    }
                }
                if ( count == 1) {

                    dp[j] = dp[j - 1] - v[j];
                    count = 0;
                }

            }
        }
        cout << "\n";

        for (int j = 0; j < n; j++) {
            cout << dp[j] << " ";
        }
        cout << "\n";

        return dp[n - 1];
    }

    void print_output(long int result) {
        ofstream fout("p2.out");
        fout << result;
        fout.close();
    }
};

int main() {
    Task task;
    task.solve();
    return 0;
}
