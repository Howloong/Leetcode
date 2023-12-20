# -*- coding: utf-8 -*-
"""
Created on Fri Nov 24 18:00:18 2023

@author: A
"""

import random
import time

import requests
from bs4 import BeautifulSoup


def searchbaidu(keyword):
    url = f"https://www.baidu.com/s?wd={keyword}"
    user_agents = [
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Edge/20.10240.16384 Safari/537.36',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Edg/85.0.564.44 Safari/537.36',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Edg/80.0.361.109 Safari/537.36',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Edg/80.0.361.57 Safari/537.36',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Edg/79.0.309.68 Safari/537.36',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Edg/78.0.276.19 Safari/537.36',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Edg/77.0.235.9 Safari/537.36',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Edg/75.0.139.8 Safari/537.36',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Edg/74.1.96.24 Safari/537.36',
        'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Edg/73.0.3683.75 Safari/537.36'
    ]
    headers = {'User-Agent': random.choice(user_agents)}
    response = requests.get(url, headers=headers)
    time.sleep(random.uniform(0.5, 3))  # 设置访问频率限制
    soup = BeautifulSoup(response.content, "html.parser")
    results = soup.find_all("div", class_="result")

    for result in results:
        try:
            title = result.find("h3").text
            link = result.h3.a['href']
            print(title)
            print(link)
        except Exception as e:
            pass


if __name__ == '__main__':
    searchbaidu("python")
