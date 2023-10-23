;;; Sierra Script 1.0 - (do not remove this comment)
(script# 445)
(include sci.sh)
(use Main)
(use LLRoom)
(use Polygon)
(use CueObj)
(use Cycle)
(use InvI)
(use PicView)
(use Obj)

(public
	rm445 0
)

(instance rm445 of LLRoom
	(properties
		lookStr {The F.B.I. laboratory is completely deserted. Perhaps they had more experiments than experimenters?}
		picture 440
		east 450
		west 435
	)
	
	(method (init)
		(Load rsVIEW 441)
		(gLarry init: normalize:)
		(if (== ((Inv at: 0) owner?) 445)
			(theDataMan init: stopUpd: approachVerbs: 3)
		)
		(if (== ((Inv at: 1) owner?) 445)
			(dataPak init: stopUpd: approachVerbs: 3)
		)
		(if (== ((Inv at: 2) owner?) 445)
			(dataPak2 init: stopUpd: approachVerbs: 3)
		)
		(machine init:)
		(desk init:)
		(computer init:)
		(contraption init:)
		(southBank init:)
		(door init:)
		(books init:)
		(duckF init:)
		(switch gGNumber
			(west
				(proc0_3)
				(self style: 12)
			)
			(else 
				(proc0_3)
				(gLarry
					posn: 278 104
					normalize:
					edgeHit: 0
					setHeading: 270
				)
			)
		)
		(super init:)
		(proc0_3)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						140
						136
						140
						161
						150
						190
						150
						231
						130
						251
						138
						305
						125
						293
						113
						263
						99
						0
						99
						0
						0
						319
						0
						319
						189
					yourself:
				)
		)
		(gLongSong2 number: 436 setLoop: -1 play:)
	)
)

(instance sGetData of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry
					view: 441
					setLoop: (if register 1 else 0)
					setCel: 0
					cycleSpeed: 12
					moveSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(1
				(switch register
					(0
						(gLarry get: 0)
						(proc0_10 5 102)
						(theDataMan dispose:)
					)
					(1
						(gLarry get: 1)
						(proc0_10 13 103)
						(dataPak dispose:)
					)
					(2
						(gLarry get: 2)
						(proc0_10 13 104)
						(dataPak2 dispose:)
					)
				)
				(gLarry setCycle: End self)
			)
			(2
				(gLarry normalize:)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance theDataMan of View
	(properties
		x 94
		y 88
		z 13
		description {the DataMan}
		approachX 82
		approachY 99
		lookStr {A tiny electronic display device lies on the counter.}
		view 440
		priority 6
		signal $0010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_2)
				(global2 setScript: sGetData 0 0)
			)
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance dataPak of View
	(properties
		x 72
		y 88
		z 14
		description {the DataPak}
		approachX 82
		approachY 99
		lookStr {What appears to be some sort of ROM cartridge lies on the counter.}
		view 440
		cel 1
		priority 6
		signal $0010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_2)
				(global2 setScript: sGetData 0 1)
			)
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance dataPak2 of View
	(properties
		x 72
		y 88
		z 12
		description {the DataPak}
		approachX 82
		approachY 99
		lookStr {What appears to be some sort of ROM cartridge lies on the counter.}
		view 440
		cel 2
		priority 6
		signal $0010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_2)
				(global2 setScript: sGetData 0 2)
			)
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance door of View
	(properties
		x 282
		y 99
		description {Doctor Phil Hopian's door}
		lookStr {This door leads back into Dr. Phil Hopian's office. After what you just went through, you're in no hurry to go back in there!}
		view 440
		loop 1
		signal $4000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 445 0))
			(5 (proc0_14 445 1))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance machine of Feature
	(properties
		x 215
		y 47
		nsTop -1
		nsLeft 170
		nsBottom 95
		nsRight 261
		description {the machine}
		sightAngle 40
		lookStr {This machine does something, you feel quite certain.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 445 2))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance computer of Feature
	(properties
		x 133
		y 91
		z 33
		nsTop 45
		nsLeft 119
		nsBottom 71
		nsRight 148
		description {the computer}
		sightAngle 40
		lookStr {If only you had paid attention when Larry chattered on and on about his computer. You know nothing about computers and are sure you'll be unable to do anything with it.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 445 3))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance contraption of Feature
	(properties
		x 114
		y 160
		z 34
		nsTop 115
		nsLeft 94
		nsBottom 137
		nsRight 134
		description {the chemistry set}
		sightAngle 40
		lookStr {This is where the technician made the flatulence powder. (Un)Fortunately, he left his equipment thoroughly clean.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 445 4))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance southBank of Feature
	(properties
		x 159
		y 166
		nsTop 144
		nsBottom 189
		nsRight 319
		description {the workbench}
		sightAngle 40
		lookStr {Lots of chemicals, beakers, and junk food wrappers fill this workbench.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (or (proc0_6 41) (proc0_6 42) (proc0_6 43))
					(proc0_14 445 5)
				else
					(proc0_14 445 6)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance books of Feature
	(properties
		x 41
		y 88
		z 30
		nsTop 49
		nsLeft 28
		nsBottom 68
		nsRight 55
		description {the books}
		sightAngle 40
		lookStr {These books are filled with Latin phrases. The only Latin phrases you know would get a sailor thrown out of a bar in Tijuana!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 445 7))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 81
		y 87
		z 17
		nsTop 54
		nsBottom 88
		nsRight 162
		description {the desk}
		sightAngle 40
		lookStr {This desk doesn't contain any secret documents; they all were burned in the big fire last week!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 445 8))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance duckF of Feature
	(properties
		x 43
		y 189
		z 42
		nsTop 134
		nsLeft 23
		nsBottom 160
		nsRight 63
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(if (== theVerb 2)
			(proc0_14 445 9)
		else
			(southBank doVerb: theVerb param2)
		)
	)
)
