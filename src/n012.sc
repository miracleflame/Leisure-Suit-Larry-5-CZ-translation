;;; Sierra Script 1.0 - (do not remove this comment)
(script# 12)
(include sci.sh)
(use Main)

(public
	proc12_0 0
)

(procedure (proc12_0)
	(if (> (Graph grGET_COLOURS) 16)
		(= global122 (Palette 5 31 31 31))
		(= global123 (Palette 5 63 63 63))
		(= global124 (Palette 5 95 95 95))
		(= global125 (Palette 5 127 127 127))
		(= global126 (Palette 5 159 159 159))
		(= global127 (Palette 5 191 191 191))
		(= global128 (Palette 5 223 223 223))
		(= global129 (Palette 5 151 27 27))
		(= gLowlightColor_4 (Palette 5 223 71 71))
		(= global131 (Palette 5 235 135 135))
		(= global132 (Palette 5 187 187 35))
		(= gLowlightColor_6 (Palette 5 219 219 39))
		(= gLowlightColor_5 (Palette 5 223 223 71))
		(= global135 (Palette 5 15 87 15))
		(= global136 (Palette 5 27 151 27))
		(= gLowlightColor_3 (Palette 5 71 223 71))
		(= global138 (Palette 5 135 235 135))
		(= global139 (Palette 5 23 23 119))
		(= global140 (Palette 5 35 35 187))
		(= global141 (Palette 5 71 71 223))
		(= global142 (Palette 5 135 135 235))
		(= global143 (Palette 5 219 39 219))
		(= gLowlightColor (Palette 5 223 71 223))
		(= gLowlightColor_2 (Palette 5 71 223 223))
		(= global146 (Palette 5 135 235 235))
		(= global147 (Palette 5 235 235 135))
	else
		(= global122 0)
		(= global123 7)
		(= global124 8)
		(= global125 7)
		(= global126 7)
		(= global127 7)
		(= global128 15)
		(= global129 4)
		(= gLowlightColor_4 12)
		(= global131 12)
		(= global132 6)
		(= gLowlightColor_6 14)
		(= gLowlightColor_5 14)
		(= global135 2)
		(= global136 2)
		(= gLowlightColor_3 10)
		(= global138 10)
		(= global139 1)
		(= global140 1)
		(= global141 9)
		(= global142 9)
		(= global143 5)
		(= gLowlightColor 13)
		(= gLowlightColor_2 3)
		(= global146 11)
		(= global147 14)
	)
)
