                                 +--------------+
                                 |  Product     |
                                 +--------------+
                                 | - name: String |
                                 | - type: String |
                                 | - color: String |
                                 | - cost: double  |
                                 | - weight: double|
                                 +--------------+
                                       /\
                                       ||
                                       \/
                                 +--------------+
                                 |   Rule       |
                                 +--------------+
                                 | - conditions: List<Condition> |
                                 | - score: int  |
                                 +--------------+
                                       /\
                                       ||
                                       \/
                                 +--------------+
                                 | Condition    |
                                 +--------------+
                                 | - attrName: String |
                                 | - value: Object     |
                                 | - operator: String  |
                                 +--------------+
