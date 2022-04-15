package com.stone.leetcode.datastruct;

import java.util.HashMap;
import java.util.Map;

// 哈希表
public class ParkingSystem {
    private final Map<Integer, Integer> parking = new HashMap<>(3);

    public ParkingSystem(int big, int medium, int small) {
        this.parking.putIfAbsent(1, big);
        this.parking.putIfAbsent(2, medium);
        this.parking.putIfAbsent(3, small);
    }

    public boolean addCar(int carType) {
        if (parking.get(carType) > 0) {
            parking.put(carType, parking.get(carType) - 1);
            return true;
        }
        return false;
    }

}


/*// 计数器
public class ParkingSystem {
    private int _big, _medium, _small;

    public ParkingSystem(int big, int medium, int small) {
        this._big = big;
        this._medium = medium;
        this._small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (_big > 0) {
                _big--;
                return true;
            }
        } else if (carType == 2) {
            if (_medium > 0) {
                _medium--;
                return true;
            }
        } else if (carType == 3) {
            if (_small > 0) {
                _small--;
                return true;
            }
        }
        return false;
    }
}*/

/*// 二进制位运算
public class ParkingSystem {
    int cnt; // [small medium big]

    public ParkingSystem(int _big, int _medium, int _small) {
        for (int i = 0; i < 30; i++) {
            int cur = 0;
            if (i < 10) {
                cur = (_big >> i) & 1;
            } else if (i < 20) {
                cur = (_medium >> (i - 10)) & 1;
            } else if (i < 30) {
                cur = (_small >> (i - 20)) & 1;
            }
            cnt += cur == 1 ? (1 << i) : 0;
        }
    }

    public boolean addCar(int ct) {
        int cur = countOfType(ct);
        if (cur > 0) {
            setCount(ct, cur - 1);
            return true;
        }
        return false;
    }

    int countOfType(int ct) {
        int ans = 0;
        int start = --ct * 10, end = start + 10;
        for (int i = start; i < end; i++) {
            if (((cnt >> i) & 1) == 1) {
                ans += (1 << (i - start));
            }
        }
        return ans;
    }

    void setCount(int ct, int pc) {
        int start = --ct * 10, end = start + 10;
        for (int i = start; i < end; i++) {
            if (((pc >> (i - start)) & 1) == 1) {
                cnt |= (1 << i);
            } else {
                cnt &= ~(1 << i);
            }
        }
    }
}*/
