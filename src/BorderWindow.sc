;;; Sierra Script 1.0 - (do not remove this comment)
(script# 936)
(include sci.sh)
(use SysWindow)


(procedure (localproc_0318 param1 param2 param3 param4 param5 param6 param7 param8 param9 param10 param11 param12 param13 &tmp temp0 temp1)
	(= temp0 (GetPort))
	(SetPort 0)
	(Graph
		grFILL_BOX
		param1
		param2
		(+ param3 1)
		(+ param4 1)
		param13
		param5
		param12
	)
	(= param1 (- param1 param10))
	(= param2 (- param2 param10))
	(= param4 (+ param4 param10))
	(= param3 (+ param3 param10))
	(Graph
		grFILL_BOX
		param1
		param2
		(+ param1 param10)
		param4
		param13
		param6
		param12
	)
	(Graph
		grFILL_BOX
		(- param3 param10)
		param2
		param3
		param4
		param13
		param8
		param12
	)
	(= temp1 0)
	(while (< temp1 param10)
		(Graph
			grDRAW_LINE
			(+ param1 temp1)
			(+ param2 temp1)
			(- param3 (+ temp1 1))
			(+ param2 temp1)
			param7
			param12
			-1
		)
		(Graph
			grDRAW_LINE
			(+ param1 temp1)
			(- param4 (+ temp1 1))
			(- param3 (+ temp1 1))
			(- param4 (+ temp1 1))
			param9
			param12
			-1
		)
		(++ temp1)
	)
	(if param11
		(Graph
			grFILL_BOX
			(+ param1 param11)
			param4
			(+ param3 param11)
			(+ param4 param11)
			param13
			0
			param12
		)
		(Graph
			grFILL_BOX
			param3
			(+ param2 param11)
			(+ param3 param11)
			param4
			param13
			0
			param12
		)
	)
	(SetPort temp0)
)

(procedure (localproc_043d param1 &tmp temp0 temp1)
	(= temp1
		(cond 
			((> (param1 bottom?) 185) (- 185 (param1 bottom?)))
			((< (param1 top?) 10) (- 10 (param1 top?)))
			(else 0)
		)
	)
	(= temp0
		(cond 
			((> (param1 right?) 315) (- 315 (param1 right?)))
			((< (param1 left?) 5) (- 5 (param1 left?)))
			(else 0)
		)
	)
	(param1
		top: (+ (param1 top?) temp1)
		bottom: (+ (param1 bottom?) temp1)
		left: (+ (param1 left?) temp0)
		right: (+ (param1 right?) temp0)
	)
)

(class BorderWindow of SysWindow
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 5
		priority 15
		window 0
		type $0000
		title 0
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
		eraseOnly 0
		underBits 0
		pUnderBits 0
		topBordColor 7
		lftBordColor 6
		rgtBordColor 4
		botBordColor 3
		bevelWid 3
		shadowWid 2
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
	)
	
	(method (dispose)
		(SetPort 0)
		(Graph grRESTORE_BOX underBits)
		(Graph grRESTORE_BOX pUnderBits)
		(if eraseOnly
			(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		else
			(Graph grREDRAW_BOX lsTop lsLeft lsBottom lsRight)
		)
		(if window
			(DisposeWindow window eraseOnly)
			(= window 0)
		)
		(DisposeClone self)
	)
	
	(method (open &tmp temp0 temp1)
		(SetPort 0)
		(= temp1 1)
		(if (!= priority -1) (= temp1 (| temp1 $0002)))
		(localproc_043d self)
		(= lsTop (- top bevelWid))
		(= lsLeft (- left bevelWid))
		(= lsRight (+ right bevelWid shadowWid))
		(= lsBottom (+ bottom bevelWid shadowWid))
		(= underBits
			(Graph grSAVE_BOX lsTop lsLeft lsBottom lsRight 1)
		)
		(if (!= priority -1)
			(= pUnderBits
				(Graph grSAVE_BOX lsTop lsLeft lsBottom lsRight 2)
			)
		)
		(localproc_0318
			top
			left
			bottom
			right
			back
			topBordColor
			lftBordColor
			botBordColor
			rgtBordColor
			bevelWid
			shadowWid
			priority
			temp1
		)
		(Graph grUPDATE_BOX lsTop lsLeft lsBottom lsRight 1)
		(= type 129)
		(super open:)
	)
)

(class InsetWindow of BorderWindow
	(properties
		top 0
		left 0
		bottom 0
		right 0
		color 0
		back 5
		priority 15
		window 0
		type $0000
		title 0
		brTop 0
		brLeft 0
		brBottom 190
		brRight 320
		eraseOnly 0
		underBits 0
		pUnderBits 0
		topBordColor 5
		lftBordColor 4
		rgtBordColor 2
		botBordColor 1
		bevelWid 3
		shadowWid 2
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		ck 3
		insideColor 2
		topBordColor2 0
		lftBordColor2 1
		botBordColor2 5
		rgtBordColor2 4
		topBordHgt 10
		botBordHgt 24
		sideBordWid 2
		shadWid 0
		bevWid 2
		xOffset 0
		yOffset 0
	)
	
	(method (open &tmp temp0 temp1 theTop theLeft theBottom theRight)
		(= temp0 1)
		(if (!= priority -1) (= temp0 (| temp0 $0002)))
		(= theTop top)
		(= theLeft left)
		(= theBottom bottom)
		(= theRight right)
		(= top (- top (+ bevelWid topBordHgt)))
		(= left (- left (+ bevelWid sideBordWid)))
		(= bottom (+ bottom bevelWid botBordHgt))
		(= right (+ right bevelWid sideBordWid))
		(= xOffset (+ bevelWid sideBordWid))
		(= yOffset (+ bevelWid topBordHgt))
		(super open:)
		(localproc_0318
			theTop
			theLeft
			theBottom
			theRight
			insideColor
			topBordColor2
			lftBordColor2
			botBordColor2
			rgtBordColor2
			bevWid
			shadWid
			priority
			temp0
		)
		(= temp1 (GetPort))
		(SetPort 0)
		(Graph
			grUPDATE_BOX
			(- theTop bevWid)
			(- theLeft bevWid)
			(+ theBottom bevWid)
			(+ theRight bevWid)
			1
		)
		(SetPort temp1)
	)
)
