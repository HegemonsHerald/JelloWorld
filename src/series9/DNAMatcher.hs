import qualified Data.Map as Map

-- The DNA Base encoding
convertTable = Map.fromList $ zip "ACGT" "TGCA"

-- Inverts a DNA Base String, dropping any Bases it doesn't know of
invertDNA dna = unMaybe $ map (flip Map.lookup convertTable) dna

-- No need to match against [], cause the fold would come back with [] anyways
unMaybe :: [Maybe Char] -> [Char]
unMaybe string = foldr (\m acc -> case m of (Just c) -> c:acc
					    Nothing  -> acc) [] string

-- Checks to see, if a DNA String contains any bases, that aren't valid
-- No DNA isn't DNA, so it's invalid
isValidDNA []  = False
isValidDNA dna = length dna == length (invertDNA dna)

-- finds position of first complete match of 'match' in 'base'
-- -1 if no match is found or either of the Strings wasn't valid DNA
findFirstMatch :: Num t => String -> String -> t
findFirstMatch match base
  | isValidDNA match && isValidDNA base = findFirstMatch' 0 (invertDNA match) base
  | otherwise = -1

-- Matches a 'match' String against 'base' and counts, how many tries
-- it took to get a match...
-- No need to check for "" explicitely, cause isValidDNA handles that
findFirstMatch' :: Num t => t -> String -> String -> t
findFirstMatch' n match base
  | match == take lm base = n	-- if match is equal to the first (length match) chars of base...
  | lm > length tb	  = -1	-- if no more match is possibly, cause 'match' is now longer, than what's left of base...
  | otherwise		  = findFirstMatch' (n+1) match tb
  where lm = length match
	tb = tail base


-- vim:sw=2:sts=2
