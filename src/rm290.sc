;;; Sierra Script 1.0 - (do not remove this comment)
(script# 290)
(include sci.sh)
(use Main)
(use LLRoom)
(use PolyPath)
(use Polygon)
(use CueObj)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm290 0
)

(local
	local0
	[local1 50]
	[local51 50]
)
(instance rm290 of LLRoom
	(properties
		lookStr {Celý život jsi pøedpokládal, že ty snobské, soukromé letištní èekárny jsou plné luxusních schùzek.}
		picture 290
		north 310
		south 270
	)
	
	(method (init)
		(Load rsVIEW 291)
		(Load rsVIEW 550)
		(Load rsVIEW 291)
		(gLarry init: normalize:)
		(door init: stopUpd:)
		(switch gGNumber
			(north
				(gLarry view: 291 setLoop: 5 setCycle: 0 posn: 152 93)
				(door posn: 111 118)
				(proc0_22 0)
				(proc0_8 32)
				(self setScript: sReturning)
			)
			(south
				(gLarry posn: 159 225)
				(self setScript: sEnter270)
			)
			(else 
				(proc0_3)
				(gLarry posn: 160 160 edgeHit: 0)
			)
		)
		(super init:)
		(cond 
			((not gGNumber) (proc0_17 90 0 global2))
			((proc0_6 32) (boardingSign init:))
			((and (gLarry has: 8) (proc0_6 8)) (proc0_17 90 0 global2))
		)
		(self
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						91
						126
						115
						126
						111
						137
						96
						145
						74
						144
						67
						150
						63
						167
						109
						189
						0
						189
						0
						0
						319
						0
						319
						189
						202
						189
						232
						169
						261
						150
						210
						123
						102
						123
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 201 132 213 137 217 144 198 150 180 148 172 145 170 137
					yourself:
				)
		)
		(chair ignoreActors: 1 init: stopUpd:)
		(ABM init:)
		(pot init: approachVerbs: 3)
		(cabinet init:)
		(light init:)
		(leftPainting init:)
		(rightPainting init:)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_5 gLarry 2) (proc0_2) (global2 setScript: sExit270))
		)
	)
	
	(method (doVerb theVerb &tmp [temp0 150])
		(switch theVerb
			(2
				(Format
					@temp0
					290
					0
					(switch global160
						(0 {Los Angeles})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
				)
				(proc0_14 @temp0)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
	
	(method (cue)
		(switch (++ local0)
			(1
				(proc0_2)
				(proc0_7 32)
				(boardingSign init:)
				(proc0_17 4 0 global2)
			)
			(2
				(gLongSong number: 297 loop: 1 play:)
				(proc0_17 5 1 global2)
			)
			(3
				(proc0_14 290 1)
				(proc0_14 290 2)
				(proc0_17 2 0 global2)
			)
			(4 (proc0_3))
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLl5Timer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance chair of View
	(properties
		x 190
		y 144
		description {židle}
		sightAngle 90
		view 290
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 290 3))
			(3 (global2 setScript: sChair))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance door of Actor
	(properties
		x 152
		y 118
		description {dveøe vedoucí k letadlu}
		sightAngle 90
		view 290
		loop 1
		priority 3
		signal $6810
		illegalBits $0000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 290 4))
			(3 (proc0_14 290 5))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance boardingSign of Prop
	(properties
		x 153
		y 62
		description {nástupní nápis}
		sightAngle 90
		view 290
		loop 2
		priority 5
		signal $4810
	)
	
	(method (init)
		(super init:)
		(self cycleSpeed: 8 setCycle: Fwd)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (proc0_6 32)
					(proc0_14 290 6)
				else
					(proc0_14 290 7)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sExit270 of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLarry setMotion: MoveTo (gLarry x?) 225 self)
			)
			(1
				(global2 newRoom: (global2 south?))
			)
		)
	)
)

(instance sEnter270 of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setMotion: MoveTo 159 160 self)
			)
			(1
				(proc0_3)
				(gLarry normalize:)
				(self dispose:)
			)
		)
	)
)

(instance ABM of Feature
	(properties
		x 185
		y 98
		nsTop 92
		nsLeft 176
		nsBottom 105
		nsRight 194
		description {automat na palubní lístky}
		sightAngle 90
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4
				(switch param2
					(7 (proc0_14 290 8))
					(8
						(if (proc0_6 32)
							(gLarry put: 8 0)
							(global2 setScript: sJetWay)
						else
							(proc0_14 290 9)
						)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(2
				(proc0_14 290 10)
				(proc0_14 290 11)
				(proc0_14 290 12 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance pot of Feature
	(properties
		x 91
		y 211
		z 100
		nsTop 107
		nsLeft 85
		nsBottom 116
		nsRight 97
		description {konvice na kávu}
		sightAngle 40
		approachX 104
		approachY 136
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 290 13))
			(3 (proc0_14 290 14))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		x 85
		y 119
		nsTop 101
		nsLeft 68
		nsBottom 137
		nsRight 102
		description {skøíòka na kávu}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 290 15))
			(3 (proc0_14 290 16))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance light of Feature
	(properties
		x 150
		y 35
		nsTop 26
		nsLeft 140
		nsBottom 45
		nsRight 161
		description {svìtlo}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 290 17))
			(3 (proc0_14 290 18))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance leftPainting of Feature
	(properties
		x 76
		y 81
		nsTop 67
		nsLeft 64
		nsBottom 96
		nsRight 89
		description {krásný obraz}
		sightAngle 40
		lookStr {Vždycky jsi obdivoval obrazy na sametu!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 290 19))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance rightPainting of Feature
	(properties
		x 229
		y 94
		nsTop 84
		nsLeft 213
		nsBottom 105
		nsRight 246
		description {krásný obraz}
		sightAngle 40
		lookStr {Naposledy jsi vidìl tak pìkné umìní v Tijuanì.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 290 19))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sChair of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(Load rsSOUND 291)
				(Load rsSOUND 295)
				(Load rsSOUND 296)
				(Load rsVIEW 291)
				(Load rsVIEW 291)
				(gLarry
					setMotion: PolyPath (- (chair x?) 10) (- (chair y?) 1) self
				)
			)
			(1
				(gLarry setHeading: 180 self)
			)
			(2
				(chair hide:)
				(gLarry
					setPri: 14
					view: 291
					setLoop: 0
					posn: (+ (chair x?) 1) (chair y?)
					cycleSpeed: 6
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(3
				(gLongSong2 number: 291 loop: 1 play:)
				(gLarry setCycle: CT 9 1 self)
			)
			(4
				(gLongSong2 number: 295 play:)
				(gLarry setCycle: End self)
			)
			(5
				(chair show:)
				(gLongSong2 number: 296 loop: 1 play:)
				(gLarry
					posn: (+ (chair x?) 44) (+ (chair y?) 3)
					setLoop: 1
					cycleSpeed: 4
					setCycle: Fwd
				)
				(= ticks 60)
			)
			(6
				(gLarry
					setLoop: 2
					cycleSpeed: 6
					setCel: 0
					setCycle: End self
				)
			)
			(7
				(gLarry
					posn: (- (gLarry x?) 12) (gLarry y?)
					normalize:
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sReturning of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (proc0_2) (= ticks 60))
			(1
				(gLarry
					setCel: 0
					cycleSpeed: 12
					moveSpeed: 5
					setCycle: End self
				)
			)
			(2
				(gLarry
					normalize:
					posn: 152 123
					loop: 2
					cycleSpeed: 7
					moveSpeed: 7
					setMotion: MoveTo 152 131 self
				)
			)
			(3
				(gLarry normalize:)
				(gLongSong2 number: 293 loop: -1 play:)
				(door setMotion: MoveTo 152 118 self)
			)
			(4
				(gLongSong2 stop:)
				(= cycles 2)
			)
			(5
				(Format
					@local1
					290
					20
					(switch global160
						(0 {Los Angeles, podvodníku})
						(1 {New York})
						(2 {Atlantic City})
						(3 {Miami})
					)
				)
				(proc0_14 @local1)
				(= ticks 60)
			)
			(6
				(cond 
					((proc0_6 9) (Format @local51 {New York}))
					((proc0_6 11) (Format @local51 {Miami}))
					((proc0_6 10) (Format @local51 {Atlantic City}))
					(else (Format @local51 {Los Angeles}))
				)
				(Format @local1 290 21 @local51)
				(proc0_14 @local1)
				(= ticks 60)
			)
			(7 (proc0_3) (self dispose:))
		)
	)
)

(instance sJetWay of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setMotion: PolyPath 179 124 self)
			)
			(1
				(gLarry
					view: 291
					setLoop: 3
					cycleSpeed: 6
					setCel: 0
					setCycle: End self
				)
			)
			(2 (= ticks 30))
			(3
				(proc0_10 7 97)
				(if (== global160 0)
					(proc0_14 290 22)
					(proc0_14 290 23)
				)
				(gLongSong2 number: 292 loop: 1 play:)
				(= ticks 30)
			)
			(4
				(gLarry cycleSpeed: 8 setCycle: Beg)
				(gLongSong2 number: 293 loop: -1 play:)
				(door setMotion: MoveTo 110 (door y?) self)
			)
			(5
				(gLongSong2 stop:)
				(gLarry normalize: setMotion: PolyPath 154 124 self)
			)
			(6
				(gLarry
					view: 291
					setLoop: 4
					cycleSpeed: 8
					setCel: 0
					posn: 152 94
					setCycle: End self
				)
			)
			(7
				(= global168 0)
				(global2 newRoom: 310)
			)
		)
	)
)
