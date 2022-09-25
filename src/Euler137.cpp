#include <iostream>
unsigned long long lim = (unsigned long long )(9e18);
unsigned long long mulmod(unsigned long long a, unsigned long long b, unsigned long long modulo)
{
  a %= modulo;
  b %= modulo;
  if (a <= lim && b <= lim)
    return (a * b) % modulo;
  if (b > a)
    std::swap(a, b);
  unsigned long long result = 0;
  while (a > 0 && b > 0)
    {
      if (b & 1)
    {
      result += a;
      if (result >= modulo)
        result -= modulo;
    }
      a <<= 1;
      if (a >= modulo)
    a -= modulo;
      b >>= 1;
    }
  return result;
}

unsigned long long nugget(unsigned long long n, unsigned long long modulo)
{
  n *= 2;
  unsigned long long fibo  [2][2]= { { 1, 1 },
                     { 1, 0 } };
  unsigned long long result[2][2]= { { 1, 0 },   // { { F(n+1), F(n)   },
                     { 0, 1 } }; //   { F(n),   F(n-1) } }
  while (n > 0)
    {
      if (n & 1)
    {
      unsigned long long t00 = mulmod(result[0][0], fibo[0][0], modulo) + mulmod(result[0][1], fibo[1][0], modulo);
      unsigned long long t01 = mulmod(result[0][0], fibo[0][1], modulo) + mulmod(result[0][1], fibo[1][1], modulo);
      unsigned long long t10 = mulmod(result[1][0], fibo[0][0], modulo) + mulmod(result[1][1], fibo[1][0], modulo);
      unsigned long long t11 = mulmod(result[1][0], fibo[0][1], modulo) + mulmod(result[1][1], fibo[1][1], modulo);
      if (t00 >= modulo) t00 -= modulo;
      if (t01 >= modulo) t01 -= modulo;
      if (t10 >= modulo) t10 -= modulo;
      if (t11 >= modulo) t11 -= modulo;
      result[0][0] = t00; result[0][1] = t01;
      result[1][0] = t10; result[1][1] = t11;
    }
      unsigned long long t00 = mulmod(fibo[0][0], fibo[0][0], modulo) + mulmod(fibo[0][1], fibo[1][0], modulo);
      unsigned long long t01 = mulmod(fibo[0][0], fibo[0][1], modulo) + mulmod(fibo[0][1], fibo[1][1], modulo);
      unsigned long long t10 = mulmod(fibo[1][0], fibo[0][0], modulo) + mulmod(fibo[1][1], fibo[1][0], modulo);
      unsigned long long t11 = mulmod(fibo[1][0], fibo[0][1], modulo) + mulmod(fibo[1][1], fibo[1][1], modulo);
      if (t00 >= modulo) t00 -= modulo;
      if (t01 >= modulo) t01 -= modulo;
      if (t10 >= modulo) t10 -= modulo;
      if (t11 >= modulo) t11 -= modulo;
      fibo[0][0] = t00; fibo[0][1] = t01;
      fibo[1][0] = t10; fibo[1][1] = t11;
      n >>= 1;
    }
  return (result[0][0] * result[0][1]) % modulo;
}

int main()
{
  const unsigned long long Modulo =     1000000007;
  unsigned int tests = 1;
  std::cin >> tests;
  while (tests--)
    {
      unsigned long long n;
      std::cin >> n;
      std::cout << nugget(n, Modulo) << std::endl;
    }
  return 0;
}
