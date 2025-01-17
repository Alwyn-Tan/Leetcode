class Solution:
    def calMoney(self, initialCurrency:int, pairs: List[List[str]], rates: List[float])-> Dict[str, float]:
        graph = defaultdict(list)

        for (x, y), r in zip(pairs, rates):
            graph[x].append(y, r)
            graph[y].append(x, 1.0/r)

        amount = {}
        def dfs(x:str, cur_money:float) -> None:
            amount[x] = cur_money 
            for currency, rate in graph[x]:
                if currency not in amount:
                    dfs(currency, cur_money * rate)
        
        dfs(initialCurrency, 1.0)
        return amount
    
    def maxAmount(self, initialCurrency: str, pairs1: List[List[str]], rates1: List[float], pairs2: List[List[str]], rates2: List[float]) -> float:
        day1 = self.calMoney(initialCurrency, pairs1, rates1)
        day2 = self.calMoney(initialCurrency, pairs2, rates2)
        return max(day1.get(x, 0.0) / d2 for x, d2 in day2.items() )