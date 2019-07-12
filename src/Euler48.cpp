
#include <iostream>

unsigned long long mulmod(unsigned long long a, unsigned long long b, unsigned long long modulo)
{
  a %= modulo;
  b %= modulo;
  if (a <= 0xFFFFFFF && b <= 0xFFFFFFF)
    return (a * b) % modulo;
  unsigned int leadingZeroes = 0;
  unsigned long long m = modulo;
  while ((m & 0x8000000000000000ULL) == 0)
  {
    leadingZeroes++;
    m <<= 1;
  }
  unsigned long long mask = (1 << leadingZeroes) - 1;
  unsigned long long result = 0;
  while (a > 0 && b > 0)
  {
    result += (b & mask) * a;
    result %= modulo;
    b >>= leadingZeroes;
    a <<= leadingZeroes;
    a  %= modulo;
  }
  return result;
}

// return (base^exponent) % modulo
unsigned long long powmod(unsigned long long base, unsigned long long exponent, unsigned long long modulo)
{
  unsigned long long result = 1;
  while (exponent > 0)
  {
    // fast exponentation:
    // odd exponent ? a^b = a*a^(b-1)
    if (exponent & 1)
      result = mulmod(result, base, modulo);

    // even exponent ? a^b = (a*a)^(b/2)
    base = mulmod(base, base, modulo);
    exponent >>= 1;
  }
  return result;
}

int main()
{
  // sum from 1^1 to x^x
  unsigned int x;
  std::cin >> x;

  // keep the last 10 digits
  const unsigned long long TenDigits = 10000000000ULL;

  unsigned long long sum = 0;
  // add all parts and don't forget the modulo ...
  for (unsigned int i = 1; i <= x; i++)
    sum += powmod(i, i, TenDigits);

  std::cout << (sum % TenDigits) << std::endl;
  return 0;
}
