#include <bits/stdc++.h>
using namespace std;

int n, m;
string A, B;
int dp[1000][1000];

int LCS()
{
    for (int i = 0; i <= n; i++)
        dp[i][0] = 0;

    for (int j = 0; j <= m; j++)
        dp[0][j] = 0;

    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= m; j++)
        {
            if (A[i - 1] == B[j - 1])
            {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
            else
            {
                dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
    }
    return dp[n][m];
}

string matched()
{
    string matching;
    stack<char> S;

    int ii = n, jj = m;

    while (ii != 0 && jj != 0)
    {
        if (A[ii - 1] == B[jj - 1])
        {
            matching += A[ii - 1];
            ii--;
            jj--;
        }
        else if (dp[ii - 1][jj] > dp[ii][jj - 1])
            ii--;
        else
            jj--;
    }
    
    reverse(matching.begin(), matching.end());
    return matching;
}

int main()
{
    cout << "Enter first string: ";
    cin >> A;
    cout << "Enter second string: ";
    cin >> B;

    n = A.size();
    m = B.size();

    printf("%d\n", LCS());
    printf("%s\n", matched().c_str());

    return 0;
}