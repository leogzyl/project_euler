(ns euler.problem15)

; Lattice paths
; Problem 15

; Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
; there are exactly 6 routes to the bottom right corner.

; How many such routes are there through a 20×20 grid?

(defn nav [i j n accum]
    (for [di [0 1]
          dj [0 1]
          :let [i1 (+ i di)
                j1 (+ j dj)]
          :when (not= [di dj] [0 0])
          :when (not= [di dj] [1 1])]
      (do 
        (prn "i" i "j" j "i1" i1 "j1" j1 "di" di "dj" dj)
        (if (= [i j] [n n])
          (flatten (conj accum [i1 j1]))
          (nav i1 j1 n (conj accum [i j]))))))
   
