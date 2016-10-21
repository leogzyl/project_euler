(ns euler.problem3)

;; Largest prime factor
;; Problem 3

;; The prime factors of 13195 are 5, 7, 13 and 29.

;; What is the largest prime factor of the number 600851475143 ?


(defn- divisors [x] 
    (filter #(zero? (rem x %))
        (range 2 (inc (Math/sqrt x)))))

(defn- prime? [x] (empty? (divisors x)))

(defn- next-prime [after] 
    (loop [x (inc after)] 
        (if (prime? x) 
            x
            (recur (inc x)))))

(def primes (iterate next-prime 2))

(defn divisible? [n m]
  (= 0 (mod n m)))
  
(defn first-prime-divisor [n]
  (first (filter (partial divisible? n) primes)))
  
(defn pfd [to-factor]
  (loop [n to-factor factors ()]
    (let [fpd (first-prime-divisor n)
          accum (conj factors fpd)]
      (if (= fpd n)
        (reverse accum)
        (recur (/ n fpd) accum)))))
        
(def problem3 (apply max (pfd 600851475143)))
