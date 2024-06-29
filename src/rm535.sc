;;; Sierra Script 1.0 - (do not remove this comment)
(script# 535)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use InvI)
(use User)
(use PicView)
(use Obj)

(public
	rm535 0
)

(local
	local0
	local1
	local2
	[local3 2]
	local5
	local6
	local7
)
(procedure (localproc_1362)
	(localproc_141f)
	(mEyes hide:)
	(switch (++ local5)
		(1
			(if
			(or (gLarry has: 12) (gLarry has: 13) (gLarry has: 11))
				(global2 setScript: sSuckFinger)
			else
				(global2 setScript: sStartGoDown)
			)
		)
		(2
			(if
			(or (gLarry has: 12) (gLarry has: 13) (gLarry has: 11))
				(global2 setScript: sCherry)
			else
				(global2 setScript: sStartGoDown)
			)
		)
		(3
			(global2 setScript: sStartGoDown)
		)
	)
)

(procedure (localproc_141f)
	(= local6 1)
	(= local7 0)
)

(instance rm535 of LLRoom
	(properties
		lookStr {Sedíš s nádhernou Michelle Milkenovou v exkluzivní soukromé kabince v exkluzivním sále Hermana Holleritha v exkluzivní kavárnì Hard Disk Cafe v exkluzivním New Yorku a usilovnì se snažíš nezírat pøes její prùsvitnou halenku.}
		picture 535
	)
	
	(method (init)
		(super init:)
		(proc0_2)
		(michelle init: stopUpd: setScript: sConversation)
		(if (not (proc0_6 16))
			(Load rsSOUND 536)
			(mEyes init: setScript: sBlink)
			(mMouth init: hide:)
			(iceCream init:)
			(cherry init:)
			(proc0_3)
			(gIconBar disable: 0)
			(User canControl: 0)
		else
			(michelle view: 540)
			(iceCream init:)
			(mMouth init: hide:)
			(proc958_0 132 538 537)
			(if (not (proc0_6 40)) (cherry init:))
			(self setScript: sGoDown)
		)
		(face init:)
		(tits init:)
	)
	
	(method (doit)
		(super doit:)
		(if (and (not script) (!= local1 (GetTime 1)))
			(= local1 (GetTime 1))
			(if (== (++ local7) 90)
				(localproc_141f)
				(proc0_2)
				(self setScript: sLoser)
			)
			(if (and (not local6) (== (++ local2) 60))
				(proc0_14 535 0)
			)
		)
	)
)

(instance sLoser of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_18 Michelle_Milken 535 1 108 139 self)
			)
			(1
				(DrawPic 1 dpOPEN_EDGECENTER)
				(michelle hide:)
				(proc0_18 gLarry 535 2 67 -1 185)
				(= seconds 3)
			)
			(2
				(proc0_14 535 3)
				(= seconds 3)
			)
			(3
				(proc0_14 535 4)
				(global2 newRoom: 510)
			)
		)
	)
)

(instance sGoDown of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== (gLongSong number?) 538)
				(== (gLongSong prevSignal?) 10)
			)
			(gLongSong number: 538 play:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 3))
			(1
				(michelle
					view: 540
					setLoop: 0
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(iceCream hide:)
				(if (IsObject cherry) (cherry hide:))
				(michelle setCycle: End self)
			)
			(3 (= seconds 2))
			(4
				(soundFX number: 537 play:)
				(= seconds 3)
			)
			(5
				(soundFX stop:)
				(michelle setLoop: 1 setCel: 0 setCycle: End self)
			)
			(6 (= seconds 3))
			(7
				(mMouth
					view: 540
					setLoop: 3
					setCel: 0
					x: (- (mMouth x?) 1)
					setPri: 14
					show:
					setCycle: End self
				)
			)
			(8 (= seconds 2))
			(9
				(mMouth hide:)
				(michelle
					view: 541
					setCel: 0
					cycleSpeed: 18
					setCycle: End self
				)
				(iceCream
					setCel: 1
					x: (michelle x?)
					y: (michelle y?)
					show:
				)
			)
			(10 (= seconds 3))
			(11
				(michelle hide:)
				(iceCream dispose:)
				(cherry dispose:)
				(DrawPic 1 dpOPEN_EDGECENTER)
				(= ticks 34)
			)
			(12
				(michelle
					view: 545
					posn: 192 119
					setLoop: 0
					setCel: 0
					show:
				)
				(DrawPic 535 16384)
				(= seconds 4)
			)
			(13
				(michelle setCel: 1)
				(proc0_14 535 5)
				(if (>= ((Inv at: 0) state?) 100)
					(proc0_9 2)
					(proc0_10 20 117)
					(proc0_14 535 6)
				else
					(proc0_14 535 7)
				)
				(= seconds 4)
			)
			(14
				(michelle setLoop: 1 setCel: 0)
				(= seconds 4)
			)
			(15
				(michelle setCel: 1)
				(= seconds 4)
			)
			(16
				(michelle setCel: 2)
				(= seconds 4)
			)
			(17
				(DrawPic 1 dpOPEN_EDGECENTER)
				(michelle hide:)
				(= seconds 3)
			)
			(18
				(if (gLarry has: 12) (gLarry put: 12) (proc0_14 535 8))
				(if (gLarry has: 13) (gLarry put: 13) (proc0_14 535 9))
				(if (gLarry has: 11)
					(gLarry put: 11)
					(proc0_14 535 10)
				)
				(proc0_10 40 116)
				(proc0_14 535 11)
				(= cycles 2)
			)
			(19 (global2 newRoom: 510))
		)
	)
)

(instance sBlink of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0 (= seconds (Random 1 4)))
			(1 (mEyes setCycle: End self))
			(2 (= cycles (Random 1 3)))
			(3 (mEyes setCycle: Beg self))
			(4 (self init:))
		)
	)
)

(instance sSuckFinger of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(mEyes hide:)
				(michelle view: 536 setCel: 0 cycleSpeed: 16 setLoop: 0)
				(= ticks 123)
			)
			(1
				(michelle setCycle: CT 7 1 self)
			)
			(2 (= seconds 5))
			(3
				(michelle setCycle: End self)
			)
			(4
				(michelle view: 535 setLoop: 0 cycleSpeed: 10 stopUpd:)
				(= seconds 2)
			)
			(5
				(proc0_18 Michelle_Milken 535 12 108 139 self)
				(mEyes show:)
				(proc0_3)
				(gIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sCherry of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(mEyes hide:)
				(michelle view: 535 setLoop: 0 stopUpd:)
				(mMouth show: setLoop: 5 setCel: 0 setCycle: End self)
			)
			(1
				(soundFX number: 536 loop: 1 play:)
				(= ticks 30)
			)
			(2
				(cherry setLoop: 7 setCycle: End cherry)
				(mMouth setCycle: Beg self)
			)
			(3
				(cherry hide:)
				(mMouth hide:)
				(= seconds 2)
			)
			(4
				(proc0_7 40)
				(proc0_18 gLarry 535 13 67 -1 185)
				(mEyes show:)
				(proc0_3)
				(gIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sStartGoDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_13 510)
				(proc0_18 Michelle_Milken 535 14 108 139 self)
			)
			(1 (= seconds 2))
			(2
				(proc0_14 535 15 67 -1 185)
				(= seconds 2)
			)
			(3
				(proc0_18 Michelle_Milken 535 16 108 139 self)
			)
			(4 (= seconds 2))
			(5
				(proc0_18 Michelle_Milken 535 17 108 139 self)
			)
			(6 (global2 newRoom: 530))
		)
	)
)

(instance sTrotter of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_18 gLarry 535 18)
				(proc0_18 Michelle_Milken 535 19 108 139 self)
			)
			(1
				(gLarry put: 11)
				(proc0_10 5 112)
				(proc0_18 Michelle_Milken 535 20 108 139 self)
			)
			(2 (localproc_1362))
		)
	)
)

(instance sCreditCards of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_18 gLarry 535 21)
				(gLarry put: 13)
				(proc0_10 5 113)
				(proc0_18 Michelle_Milken 535 22 108 139 self)
			)
			(1 (localproc_1362))
		)
	)
)

(instance sMoney of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_18 gLarry 535 23)
				(gLarry put: 12)
				(proc0_10 5 114)
				(proc0_18 Michelle_Milken 535 24 108 139 self)
			)
			(1 (localproc_1362))
		)
	)
)

(instance sConversation of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(proc0_18 gLarry 535 25 67 -1 185)
				(proc0_18 Michelle_Milken 535 26 108 67 -1 185)
			)
			(2
				(proc0_18 gLarry 535 27 67 -1 185)
				(proc0_18 Michelle_Milken 535 28 108 139 self 67 -1 185)
			)
			(3
				(proc0_18 gLarry 535 29 67 -1 185)
				(proc0_18 Michelle_Milken 535 30 108 67 -1 185)
			)
			(4
				(proc0_18 gLarry 535 31 67 -1 185)
				(proc0_18 Michelle_Milken 535 32 108 139 self 67 -1 185)
			)
			(5
				(proc0_18 gLarry 535 33 67 -1 185)
				(proc0_18 Michelle_Milken 535 34 108 67 -1 185)
			)
			(6
				(proc0_18 gLarry 535 35 67 -1 185)
				(proc0_18 Michelle_Milken 535 36 108 139 self 67 -1 185)
			)
			(7
				(proc0_18 Michelle_Milken 535 37 108 139 self 67 -1 185)
			)
			(8
				(proc0_18 gLarry 535 38 67 -1 185)
			)
			(9
				(proc0_18 gLarry 535 39 67 -1 185)
				(proc0_18 Michelle_Milken 535 40 108 139 self 67 -1 185)
			)
			(10
				(proc0_10 5 115)
				(proc0_18 gLarry 535 41 67 -1 185)
				(proc0_2)
				(global2 setScript: sStartGoDown)
			)
		)
	)
)

(instance michelle of Actor
	(properties
		x 150
		y 105
		description {Michelle Milkenová}
		sightAngle 90
		yStep 1
		view 535
		priority 3
		signal $5010
		cycleSpeed 10
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 535 42)
				(proc0_14 535 43 67 -1 185)
			)
			(3 (proc0_14 535 44))
			(10 (proc0_14 535 45))
			(4
				(switch param2
					(12
						(proc0_2)
						(localproc_141f)
						(global2 setScript: sMoney)
					)
					(13
						(proc0_2)
						(localproc_141f)
						(global2 setScript: sCreditCards)
					)
					(11
						(proc0_2)
						(localproc_141f)
						(global2 setScript: sTrotter)
					)
					(6 (proc0_14 535 46))
					(else  (proc0_14 535 47))
				)
			)
			(5
				(= local6 1)
				(sConversation cue:)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance mEyes of Prop
	(properties
		x 153
		y 65
		description {její oèi}
		sightAngle 90
		lookStr {Její smyslné oèi se ti vypalují do duše.}
		view 535
		loop 2
		priority 13
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(michelle doVerb: theVerb param2)
	)
)

(instance mMouth of Prop
	(properties
		x 153
		y 68
		description {její ústa}
		sightAngle 90
		lookStr {Její rty jsou vlhké a vyzývavé.}
		view 535
		loop 4
		priority 14
		signal $4010
		cycleSpeed 10
	)
	
	(method (doVerb theVerb param2)
		(michelle doVerb: theVerb param2)
	)
)

(instance iceCream of View
	(properties
		x 151
		y 126
		nsTop 118
		nsLeft 137
		nsBottom 142
		nsRight 165
		description {zmrzlina}
		sightAngle 90
		lookStr {Miluješ zmrzlinu. A šlehaèku. Šlehaèku podávanou na speciálním podnosu, který nápadnì pøipomíná ženské tìlo!}
		view 535
		loop 6
		signal $4000
	)
)

(instance cherry of Prop
	(properties
		x 148
		y 101
		description {její tøešnì}
		sightAngle 90
		lookStr {Její tøešnì vypadají mìkce, èervenì, jsou zralé a pøipravené k utržení!}
		view 535
		loop 9
		cel 1
		priority 14
		signal $4010
	)
	
	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance tits of Feature
	(properties
		x 151
		y 130
		nsTop 107
		nsLeft 130
		nsBottom 127
		nsRight 172
		description {její òadra}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 535 48))
			(3 (proc0_14 535 49))
			(else 
				(michelle doVerb: theVerb param2)
			)
		)
	)
)

(instance face of Feature
	(properties
		x 155
		y 130
		nsTop 49
		nsLeft 132
		nsBottom 93
		nsRight 179
		description {její oblièej}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 535 50))
			(3
				(proc0_18 Michelle_Milken 535 51 108)
			)
			(else 
				(michelle doVerb: theVerb param2)
			)
		)
	)
)

(instance Michelle_Milken of Talker
	(properties
		x 8
		y 5
		nsTop 58
		nsLeft 142
		view 1535
		loop 1
		talkWidth 300
		name "Michelle Milkenová"
	)
	
	(method (init)
		(= eyes MMEyes)
		(= mouth MMMouth)
		(super init: &rest)
	)
)

(instance MMEyes of Prop
	(properties
		nsLeft 1
		view 1535
		loop 2
		signal $4000
		cycleSpeed 25
	)
)

(instance MMMouth of Prop
	(properties
		nsTop 10
		nsLeft 7
		view 1535
		signal $4000
	)
)

(instance soundFX of Sound
	(properties
		flags $0001
		loop -1
	)
)
