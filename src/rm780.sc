;;; Sierra Script 1.0 - (do not remove this comment)
(script# 780)
(include sci.sh)
(use Main)
(use LLRoom)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm780 0
)

(instance rm780 of LLRoom
	(properties
		lookStr {Tak jsi to dokázal! Plaveš pod krásnou Trampovou promenádou a bájeènì se bavíš. Otázka zní: jak daleko od bøehu jsi?}
		picture 780
		north 760
		west 700
	)
	
	(method (init)
		(gLarry
			init:
			normalize: 781
			setCycle: Fwd
			actions: swimActions
		)
		(if (!= gGNumber 700)
			(proc0_3)
			(gLarry posn: 160 175 setHeading: 0 edgeHit: 0)
		)
		(super init:)
		(sky init:)
		(boardwalk init:)
		(post1 init:)
		(post2 init:)
		(post3 init:)
		(post4 init:)
		(wave1 setCycle: Fwd init:)
		(wave2 setCycle: Fwd init:)
		(wave3 setCycle: Fwd init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 0 319 0 319 155 175 155 175 158 115 158 115 155 0 155
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 8 180 8 166 157 166 157 180
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 162 180 162 166 242 166 242 180
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 266 180 266 166 319 166 319 180
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 0 189 0 187 319 187 319 189
					yourself:
				)
		)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_5 gLarry 4) (self setScript: sScroll 0 2))
			((and (proc0_5 gLarry 8) global159) (self setScript: sScroll 0 4))
		)
	)
)

(instance sScroll of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setMotion: MoveFwd 40 self)
			)
			(1
				(if (== register 4)
					(-- global159)
					(gLarry x: (+ (gLarry x?) 320))
					(global2 drawPic: (global2 picture?) 11)
				else
					(++ global159)
					(gLarry x: (- (gLarry x?) 320))
					(global2 drawPic: (global2 picture?) 12)
				)
				(= cycles 1)
			)
			(2 (proc0_3) (self dispose:))
		)
	)
)

(instance wave1 of Prop
	(properties
		x 146
		y 145
		view 780
		priority 1
		signal $4010
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2)
	)
)

(instance wave2 of Prop
	(properties
		x 115
		y 180
		view 780
		loop 1
		priority 1
		signal $4010
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2)
	)
)

(instance wave3 of Prop
	(properties
		x 275
		y 179
		view 780
		loop 2
		priority 1
		signal $4010
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(global2 doVerb: theVerb param2)
	)
)

(instance sky of Feature
	(properties
		x 159
		y 176
		z 171
		nsBottom 11
		nsRight 319
		description {obloha}
		sightAngle 40
		lookStr {Pøi pohledu na oblohu si vzpomeneš na lepší èasy, vlastnì jen pøed nìkolika minutami, kdy jsi byl mnohem blíž obloze než teï.}
	)
)

(instance boardwalk of Feature
	(properties
		x 159
		y 176
		z 122
		nsTop 12
		nsBottom 96
		nsRight 319
		description {promenáda}
		sightAngle 40
		lookStr {Máš zvláštní pocit - skoro jako bys nìkomu koukal pod sukni!}
	)
)

(instance post1 of Feature
	(properties
		x 44
		y 134
		nsTop 96
		nsLeft 26
		nsBottom 173
		nsRight 62
		description {sloupek}
		sightAngle 40
		lookStr {Ty sloupy vypadají mnohem vyšší než shora.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 780 0))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance post2 of Feature
	(properties
		x 118
		y 98
		nsTop 21
		nsLeft 104
		nsBottom 175
		nsRight 132
		description {sloup}
		sightAngle 40
	)
	
	(method (doVerb)
		(post1 doVerb: &rest)
	)
)

(instance post3 of Feature
	(properties
		x 203
		y 99
		nsTop 21
		nsLeft 190
		nsBottom 177
		nsRight 216
		description {sloup}
		sightAngle 40
	)
	
	(method (doVerb)
		(post1 doVerb: &rest)
	)
)

(instance post4 of Feature
	(properties
		x 303
		y 101
		nsTop 24
		nsLeft 287
		nsBottom 179
		nsRight 319
		description {sloup}
		sightAngle 40
	)
	
	(method (doVerb)
		(post1 doVerb: &rest)
	)
)

(instance swimActions of Actions
	(properties)
	
	(method (doVerb theVerb)
		(return
			(switch theVerb
				(2 (proc0_14 780 1))
				(3 (proc0_14 780 2))
				(else  (return 0))
			)
		)
	)
)
