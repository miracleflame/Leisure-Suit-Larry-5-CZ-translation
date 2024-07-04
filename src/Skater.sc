;;; Sierra Script 1.0 - (do not remove this comment)
(script# 760)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use MoveFwd)
(use ForwardCounter)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use InvI)
(use User)
(use PicView)
(use Obj)

(public
	rm760 0
	bench 1
)

(local
	local0
	local1
	local2
	thePEventMessage
	local4
	local5
	local6
	local7
	pEventX
	pEventY
	thePicView
	local11
	[local12 4] = [0 82 103 124]
	[local16 11] = [103 124 145]
	[local27 17] = [53 53 53 53 53 53 53 53 53 53 53 53 53 106 106 53 159]
	local44
)
(instance rm760 of LLRoom
	(properties
		lookStr {Komercializace Trampovy krásné promenády se zdá být dokonèena. Podniky lemují každý centimetr vzdálené strany promenády. Alespoò ta bližší strana zùstala otevøená pro rybáøe a bruslaøe.}
		picture 760
		north 790
		east 760
		south 780
		west 700
	)
	
	(method (init &tmp temp0)
		(proc958_0
			128
			763
			762
			761
			764
			771
			772
			773
			774
			775
			776
			777
			778
			779
			769
			770
			791
			1731
			1795
		)
		(gLongSong number: 700 loop: -1 play:)
		(if (gLarry skating?)
			(= local5 765)
			(= local6 768)
		else
			(= local5 761)
			(= local6 764)
		)
		(gLarry init: normalize: local6 setStep: 3 3)
		(switch gGNumber
			(north
				(proc0_3)
				(gLarry
					view: local5
					posn: 204 85
					setHeading: 180
					edgeHit: 0
				)
			)
			(west
				(self setScript: sFromWest)
			)
			(else 
				(proc0_3)
				(= local5 765)
				(= local6 768)
				(gLarry
					posn: 160 145
					edgeHit: 0
					skating: 1
					normalize: local6
				)
				(= global108 2)
				(= local44 99)
			)
		)
		(super init:)
		(skater1 init:)
		(skater2 init:)
		(skater3 init:)
		(skater4 init:)
		(skater5 init:)
		(skater6 init:)
		(skater7 init:)
		(skater8 init:)
		(skater9 init:)
		(bench init:)
		(post1 init:)
		(post2 init:)
		(post3 init:)
		(post4 init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 90 145 154 145 154 160 90 160
					yourself:
				)
		)
		(gLl5DirHandler addToFront: self)
		(gLl5MDHandler addToFront: self)
		(gLl5KDHandler addToFront: self)
	)
	
	(method (doit &tmp [temp0 80])
		(super doit:)
		(cond 
			((not (proc999_5 script 0 sMoveLarry)))
			((proc0_5 gLarry 4) (self setScript: sScroll 0 2))
			((proc0_5 gLarry 8)
				(cond 
					(global159 (self setScript: sScroll 0 4))
					((and (gLarry skating?) (not local2))
						(if (not local1) (proc0_14 760 0) (= local1 1))
						(proc0_2)
						(gLarry
							setMotion: MoveTo (+ (gLarry x?) 10) (gLarry y?) self
						)
						(= local2 1)
					)
				)
			)
		)
		(if
			(and
				(gLarry skating?)
				(gLarry mover?)
				(< global108 3)
				(== (++ local44) 100)
			)
			(= local44 0)
			(if
			(and (== (++ global108) 3) (not (proc0_6 3)))
				(lana init:)
			)
		)
	)
	
	(method (dispose)
		(gLl5DirHandler delete: self)
		(gLl5MDHandler delete: self)
		(gLl5KDHandler delete: self)
		(gLongSong fade:)
		(super dispose:)
	)
	
	(method (handleEvent pEvent &tmp temp0 temp1)
		(= temp0 (pEvent type?))
		(= temp1 (pEvent message?))
		(cond 
			((and (& temp0 $0040) (== temp1 0)) (pEvent claimed: 0))
			(
				(or
					(and
						(proc999_5 temp0 1 4)
						(not (pEvent modifiers?))
						(== gCursorNumber 6)
					)
					(and (== temp0 16384) (== temp1 1))
				)
				(sMeetLana cue:)
			)
			((== (gLarry script?) sMeetLana) 0)
			((not (User canControl:)) (pEvent claimed: 1))
			((& temp0 $0040)
				(if (not (gLarry sitting?))
					(if
					(and (gLarry mover?) (== temp1 thePEventMessage))
						(gLarry setMotion: 0)
						(= thePEventMessage 0)
					else
						(switch temp1
							(1
								(pEvent x: (gLarry x?) y: (- (gLarry y?) 20))
							)
							(2
								(pEvent x: (+ (gLarry x?) 100) y: (- (gLarry y?) 20))
							)
							(3
								(pEvent x: 1000 y: (gLarry y?))
							)
							(4
								(pEvent x: (+ (gLarry x?) 20) y: (+ (gLarry y?) 20))
							)
							(5
								(pEvent x: (gLarry x?) y: (+ (gLarry y?) 20))
							)
							(6
								(pEvent x: (- (gLarry x?) 20) y: (+ (gLarry y?) 20))
							)
							(7
								(pEvent x: 0 y: (gLarry y?))
							)
							(8
								(pEvent x: (- (gLarry x?) 20) y: (- (gLarry y?) 20))
							)
							(0
								(gIconBar advanceCurIcon:)
								(pEvent claimed: 1)
							)
						)
						(if (!= temp1 0)
							(= pEventX (pEvent x?))
							(= pEventY (pEvent y?))
							(if (proc999_5 (global2 script?) 0 sMoveLarry)
								(global2 setScript: sMoveLarry)
							)
						)
					)
					(= thePEventMessage temp1)
				else
					(global2 setScript: sStandUp 0 0)
				)
				(pEvent claimed: 1)
			)
			(
				(or
					(and
						(== temp0 1)
						(not (pEvent modifiers?))
						(or
							(== (gIconBar curIcon?) (gIconBar at: 0))
							(== temp1 1)
						)
					)
					(and (== temp0 4) (== temp1 13))
				)
				(cond 
					((gLarry sitting?) (pEvent claimed: 1) (global2 setScript: sStandUp 0 0))
					((proc999_5 (global2 script?) 0 sMoveLarry)
						(= pEventX (pEvent x?))
						(if (> (= pEventY (pEvent y?)) 158)
							(if (not (gLarry skating?))
								(global2 setScript: sFall)
							else
								(= pEventY 145)
								(global2 setScript: sMoveLarry)
							)
						else
							(if (> pEventY 145) (= pEventY 145))
							(global2 setScript: sMoveLarry)
						)
					)
				)
			)
		)
	)
	
	(method (cue)
		(if local2
			(= local2 0)
			(proc0_3)
		else
			(gLarry edgeHit: 1)
			(global2 newRoom: (global2 north?))
		)
	)
	
	(method (drawPic picNumber &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (!= picNumber 795)
			(gCast eachElementDo: #perform showSkaterCode)
			(gAddToPics dispose:)
			(super drawPic: picNumber &rest)
			(= temp4 1)
			(= temp0 0)
			(while (< temp4 318)
				(= temp3 (* (+ global159 1) temp0 37))
				(if (& $0001 (>> temp3 temp0)) (= temp3 (/ temp3 17)))
				(if (and (== global159 3) (== temp0 3))
					(= temp2 2)
					(= temp3 0)
					(= temp5 106)
				else
					(= temp5 [local27 (= temp3 (mod temp3 17))])
					(= temp2 0)
					(if (> temp3 8) (= temp3 (- temp3 9)) (= temp2 1))
				)
				(= temp6
					(/ (CelWide (theBuilding view?) temp2 temp3) 2)
				)
				((theBuilding new:)
					x: temp4
					loop: temp2
					cel: temp3
					approachX: (proc999_2 300 (+ temp4 temp6))
					approachY: 85
					init:
				)
				(= temp4 (+ temp4 temp5))
				(++ temp0)
			)
			(gAddToPics doit:)
		else
			(super drawPic: picNumber &rest)
		)
	)
)

(class Skater of Actor
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		description 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 26505
		lookStr 0
		yStep 2
		view 0
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $4000
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		palette 0
		cycleSpeed 12
		script 0
		cycler 0
		timer 0
		detailLevel 0
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		moveSpeed 6
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
		room 0
		freq 1
		nearLarry 0
		paused 0
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init:)
		(= x 160)
		(self cue:)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(nearLarry (-- nearLarry))
			(
				(and
					(== room global159)
					(< (gLarry distanceTo: self) 30)
				)
				(= nearLarry 18)
			)
			((and (not mover) (proc999_5 x 0 320)) (self cue:))
		)
		(cond 
			((<= freq 0))
			((== loop 0)
				(cond 
					((and (== nearLarry 18) (self isNotHidden:)) (self turn: 4))
					((and (< 300 x) (< x 312))
						(cond 
							((or (== (Random 1 freq) 1) (== room 20)) (self turn: 4))
							((& signal $0080)
								(++ room)
								(= x (- x 320))
								(self setMotion: MoveTo 320 y)
								(if (== room global159) (self show:))
							)
							(else (self freq: (* freq -1) setMotion: MoveFwd 40 self))
						)
					)
				)
			)
			((== loop 1)
				(cond 
					((and (== nearLarry 18) (self isNotHidden:)) (self turn: 2))
					((and (< 13 x) (< x 25))
						(cond 
							((or (== (Random 1 freq) 1) (== room 0)) (self turn: 2))
							((& signal $0080)
								(-- room)
								(= x (+ x 320))
								(self setMotion: MoveTo 0 y)
								(if (== room global159) (self show:))
							)
							(else (self freq: (* freq -1) setMotion: MoveFwd 40 self))
						)
					)
				)
			)
		)
	)
	
	(method (cue)
		(if (== loop 1)
			(-- room)
			(self
				x: (+ x 320)
				hide:
				setMotion: MoveTo 0 y
				freq: (if (< freq 0) (* freq -1) else freq)
				nearLarry: 0
			)
		else
			(++ room)
			(self
				x: (- x 320)
				hide:
				setMotion: MoveTo 320 y
				freq: (if (< freq 0) (* freq -1) else freq)
				nearLarry: 0
			)
		)
	)
	
	(method (turn param1)
		(switch param1
			(4
				(self setLoop: 1 setMotion: MoveTo 0 y)
			)
			(2
				(self setLoop: 0 setMotion: MoveTo 320 y)
			)
		)
	)
)

(instance lana of Skater
	(properties
		y 145
		description {Lahodná Lana}
		view 769
		cycleSpeed 10
		xStep 6
		freq 99
	)
	
	(method (init &tmp temp0 temp1)
		(super init:)
		(= temp0 (proc999_3 0 (- global159 4)))
		(= temp1 (proc999_2 20 (+ global159 4)))
		(while (== (= room (Random temp0 temp1)) global159)
		)
		(if (> room global159)
			(self setLoop: 1)
		else
			(self setLoop: 0)
		)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== room global159)
				(not (& signal $0088))
				(not local0)
				(< 20 x)
				(< x 300)
			)
			(proc0_14 760 1)
			(= local0 1)
			(= freq 6)
		)
		(if
			(and
				local0
				(not local4)
				(or (== (gLarry y?) y) (gLarry sitting?))
				(< (gLarry distanceTo: self) 40)
				(self isNotHidden:)
			)
			(= local4 1)
			(gLarry setScript: sMeetLana)
		)
	)
	
	(method (dispose)
		(proc0_3)
		(super dispose:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 760 1))
			(5
				(if (or (< (lana x?) 25) (> (lana x?) 300))
					(proc0_14 760 2)
				else
					(= local4 1)
					(gLarry setScript: sMeetLana)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(cond 
			((not freq) (self dispose:))
			((== loop 1)
				(-- room)
				(self
					x: (+ x 320)
					hide:
					setMotion: MoveTo 0 y
					freq: (* freq -1)
				)
			)
			(else
				(++ room)
				(self
					x: (- x 320)
					hide:
					setMotion: MoveTo 320 y freq (* freq -1)
				)
			)
		)
	)
	
	(method (turn)
		(if nearLarry (= nearLarry 0) else (super turn: &rest))
	)
)

(instance skater1 of Skater
	(properties
		y 140
		description {Mistr Z}
		lookStr {No není roztomilý?}
		view 771
		xStep 8
		room 3
		freq 4
	)
	
	(method (doit)
		(if (not paused) (super doit:))
	)
	
	(method (checkDetail)
		(if (> (gGame detailLevel:) 1)
			(if (>= z 1000) (self perform: zCode))
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000) (self perform: zCode))
		)
	)
)

(instance skater2 of Skater
	(properties
		y 121
		description {starý muž}
		lookStr {Na bruslaøe je trochu starý, ne?}
		view 772
		xStep 8
		room 3
		freq 4
	)
	
	(method (doit)
		(if (not paused) (super doit:))
	)
	
	(method (checkDetail)
		(if (> (gGame detailLevel:) 1)
			(if (>= z 1000) (self perform: zCode))
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000) (self perform: zCode))
		)
	)
)

(instance skater3 of Skater
	(properties
		y 118
		z 10
		description {Horký Kola}
		lookStr {Ten kluk se opravdu pøedvádí!}
		view 773
		xStep 8
		room 1
		freq 3
	)
	
	(method (doit)
		(if (not paused) (super doit:))
	)
	
	(method (checkDetail)
		(if (> (gGame detailLevel:) 2)
			(if (>= z 1000) (self perform: zCode))
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000) (self perform: zCode))
		)
	)
)

(instance skater4 of Skater
	(properties
		y 116
		description {Trsající Roller}
		lookStr {Co to vlastnì poslouchá?}
		view 774
		xStep 6
		room 2
		freq 2
	)
	
	(method (doit)
		(if (not paused) (super doit:))
	)
	
	(method (checkDetail)
		(if (> (gGame detailLevel:) 2)
			(if (>= z 1000) (self perform: zCode))
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000) (self perform: zCode))
		)
	)
)

(instance skater5 of Skater
	(properties
		y 142
		description {Roller Prase}
		lookStr {To je ale talent! Umí jíst a zároveò bruslit!}
		view 775
		xStep 8
		room 2
		freq 2
	)
	
	(method (doit)
		(if (not paused) (super doit:))
	)
	
	(method (checkDetail)
		(if (> (gGame detailLevel:) 3)
			(if (>= z 1000) (self perform: zCode))
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000) (self perform: zCode))
		)
	)
)

(instance skater6 of Skater
	(properties
		y 117
		description {Kravaák Bill}
		lookStr {Na tuhle promenádu je až moc obleèený!}
		view 776
		xStep 6
		room 2
		freq 2
	)
	
	(method (doit)
		(if (not paused) (super doit:))
	)
	
	(method (checkDetail)
		(if (> (gGame detailLevel:) 3)
			(if (>= z 1000) (self perform: zCode))
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000) (self perform: zCode))
		)
	)
)

(instance skater7 of Skater
	(properties
		y 131
		description {Dìcko Blb}
		lookStr {To je ale pøitroublý kluèina! Okamžitì se stává tvým oblíbencem!}
		view 777
		xStep 8
		room 2
		freq 2
	)
	
	(method (doit)
		(if (not paused) (super doit:))
	)
	
	(method (checkDetail)
		(if (> (gGame detailLevel:) 4)
			(if (>= z 1000) (self perform: zCode))
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000) (self perform: zCode))
		)
	)
)

(instance skater8 of Skater
	(properties
		y 110
		description {bruslaø}
		lookStr {Nemìl jsi tušení, že na promenádì bude tolik bruslaøù!}
		view 778
		xStep 6
		room 2
		freq 2
	)
	
	(method (doit)
		(if (not paused) (super doit:))
	)
	
	(method (checkDetail)
		(if (> (gGame detailLevel:) 4)
			(if (>= z 1000) (self perform: zCode))
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000) (self perform: zCode))
		)
	)
)

(instance skater9 of Skater
	(properties
		y 91
		description {bruslaø}
		lookStr {Bruslaø, který se nikdy nevzdálí od obchodù na druhé stranì promenády, najde opravdové štìstí, když své srdíèko rozbruslí!}
		view 779
		xStep 6
		room 2
		freq 2
	)
	
	(method (doit)
		(if (not paused) (super doit:))
	)
	
	(method (checkDetail)
		(if (> (gGame detailLevel:) 4)
			(if (>= z 1000) (self perform: zCode))
			(= paused 0)
		else
			(= paused 1)
			(if (< z 1000) (self perform: zCode))
		)
	)
)

(instance zCode of Code
	(properties)
	
	(method (doit param1)
		(if (== (param1 z?) 1000)
			(param1 z: 0)
		else
			(param1 z: 1000)
		)
	)
)

(instance showSkaterCode of Code
	(properties)
	
	(method (doit param1)
		(if (param1 respondsTo: #freq)
			(if (== (param1 room?) global159)
				(param1 show:)
			else
				(param1 hide:)
			)
		)
	)
)

(instance theBuilding of PicView
	(properties
		y 80
		description {budova}
		view 760
	)
	
	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(switch loop
					(0
						(switch cel
							(0 (proc0_14 760 3))
							(1 (proc0_14 760 4))
							(2 (proc0_14 760 5))
							(3 (proc0_14 760 6))
							(4 (proc0_14 760 7))
							(5 (proc0_14 760 8))
							(6 (proc0_14 760 9))
							(7 (proc0_14 760 10))
							(8 (proc0_14 760 11))
						)
					)
					(1
						(switch cel
							(0 (proc0_14 760 12))
							(1 (proc0_14 760 13))
							(2 (proc0_14 760 14))
							(3 (proc0_14 760 15))
							(4 (proc0_14 760 16))
							(5 (proc0_14 760 17))
							(6 (proc0_14 760 18))
							(7 (proc0_14 760 19))
						)
					)
					(2 (proc0_14 760 20))
				)
			)
			(3
				(if
					(and
						(== (gLarry view?) local5)
						(== (gLarry x?) approachX)
						(== (gLarry y?) approachY)
					)
					(if (== loop 2)
						(if (gLarry skating?)
							(proc0_14 760 21)
						else
							(gLarry setHeading: 0 global2)
						)
					else
						(proc0_14 760 22)
						(proc0_14 760 23 67 -1 185)
					)
				else
					(global2
						handleEvent:
							(= temp0
								((Event new:)
									type: 1
									message: 1
									x: approachX
									y: approachY
								)
							)
					)
					(= thePicView self)
					(= local11 3)
					(temp0 dispose:)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sSplash of Sound
	(properties
		number 761
	)
)

(instance splash of Prop
	(properties
		y 189
		view 770
		loop 2
	)
)

(instance rightEye of Prop
	(properties
		x 165
		y 180
		z 119
		description {Lanino pravé oko}
		view 795
	)
	
	(method (doVerb)
		(lanaFtr doVerb: &rest)
	)
)

(instance leftEye of Prop
	(properties
		x 140
		y 180
		z 123
		description {Lanino levé oko}
		view 795
		loop 2
	)
	
	(method (doVerb)
		(lanaFtr doVerb: &rest)
	)
)

(instance nose of Prop
	(properties
		x 149
		y 180
		z 108
		description {Lanin nos}
		view 795
		loop 1
		cycleSpeed 18
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
	
	(method (doVerb)
		(lanaFtr doVerb: &rest)
	)
)

(instance lanaMouth of Prop
	(properties
		x 149
		y 180
		z 102
		description {Lanina pusa}
		view 795
		loop 3
	)
	
	(method (doVerb)
		(lanaFtr doVerb: &rest)
	)
)

(instance Lana_Luscious_ of Talker
	(properties
		x 140
		y 160
		nsTop 70
		nsLeft 140
		view 1795
		loop 1
		name "Lana Lahodná"
	)
	
	(method (init)
		(= mouth lanaCMouth)
		(super init: &rest)
	)
)

(instance lanaCMouth of Prop
	(properties
		view 1795
	)
)

(instance Lana_Luscious of Talker
	(properties
		nsTop 100
		nsLeft 5
		view 1731
		loop 3
		viewInPrint 1
		name "Lana Lahodná"
	)
	
	(method (init)
		(= bust lanaFBust)
		(= mouth lanaFMouth)
		(= eyes lanaFEyes)
		(super init: &rest)
	)
)

(instance lanaFBust of View
	(properties
		view 1731
		loop 1
	)
)

(instance lanaFMouth of Prop
	(properties
		nsTop 40
		nsLeft 23
		view 1731
	)
)

(instance lanaFEyes of Prop
	(properties
		nsTop 31
		nsLeft 29
		view 1731
		loop 2
		cycleSpeed 12
	)
)

(instance sFromWest of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry
					view: 764
					posn: -10 145
					setMotion: MoveFwd 40 self
				)
			)
			(1
				(proc0_3)
				((gLarry looper?) dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sFall of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (proc0_5 gLarry 16384)
			(gLarry setMotion: MoveTo (gLarry x?) 145)
			(proc0_3)
			(if (== (global2 script?) sMoveLarry)
				(sMoveLarry dispose:)
			)
			(self dispose:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if (< (gLarry y?) 145)
					(sMoveLarry next: self)
					(= pEventY 145)
					(client setScript: sMoveLarry)
				else
					(gLarry
						setLoop: 2
						setCycle: StopWalk -1
						setMotion: PolyPath (gLarry x?) 158 self
					)
				)
			)
			(1
				(gLarry
					view: 770
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: End
				)
				(= cycles 10)
			)
			(2
				(gLarry setLoop: 1 setCel: 0 setCycle: End)
				(= ticks 90)
			)
			(3
				(sSplash play:)
				(splash init: x: (gLarry x?) setCycle: End self)
			)
			(4 (global2 newRoom: 780))
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

(instance sMeetLana of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gLarry y?) 145)
					(= pEventY 145)
					(= thePicView self)
					(global2 setScript: sMoveLarry)
				else
					(= cycles 1)
				)
			)
			(1
				(proc0_2)
				(if (== (global2 script?) sMoveLarry)
					(sMoveLarry dispose:)
				)
				(proc0_10 6 138)
				(if (and (gLarry sitting?) (!= (gLarry loop?) 4))
					(self setScript: sStandUp self 0)
				else
					(= cycles 2)
				)
			)
			(2
				(lana setMotion: 0)
				(proc0_18 gLarry 760 24)
				(proc0_18 Lana_Luscious 760 25 108)
				(= ticks 30)
			)
			(3
				(proc0_18 gLarry 760 26)
				(proc0_18 Lana_Luscious 760 27 108)
				(= ticks 30)
			)
			(4
				(proc0_18 gLarry 760 28)
				(= ticks 30)
			)
			(5
				(gLarry
					setLoop: -1
					setCycle: StopWalk -1
					setMotion: MoveTo 145 145 self
				)
				(lana setScript: sLanaSits self)
			)
			(6
				(gLarry view: 791 setLoop: 4 setCel: 0 setCycle: End)
			)
			(7
				(gLarry
					setLoop: 5
					setCel: 0
					setCycle: End self
					sitting: 1
				)
			)
			(8
				(gCast eachElementDo: #perform zCode)
				(proc0_22 1)
				(global2 drawPic: 795 100)
				(proc0_3)
				(rightEye init:)
				(leftEye init:)
				(nose init:)
				(lanaMouth init:)
				(gFeatures addToFront: lanaFtr)
			)
			(9
				(proc0_2)
				(proc0_22 0)
				(global2 drawPic: 760 100)
				(rightEye dispose:)
				(leftEye dispose:)
				(nose dispose:)
				(lanaMouth dispose:)
				(lanaFtr dispose:)
				(gAddToPics doit:)
				(gCast eachElementDo: #perform zCode)
				(skater1 cue:)
				(skater2 cue:)
				(skater3 cue:)
				(skater4 cue:)
				(skater5 cue:)
				(skater6 cue:)
				(skater7 cue:)
				(skater8 cue:)
				(skater9 cue:)
				(= cycles 3)
			)
			(10
				(lana
					freq: 0
					setLoop: 5
					setCel: 255
					posn: 107 145
					setCycle: Beg self
				)
			)
			(11 (gLarry setCycle: Beg self))
			(12
				(gLarry setLoop: 4 setCel: 255)
				(lana
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo -20 145 lana
				)
				(skater5 setPri: 10)
				(proc0_7 3)
				(self dispose:)
			)
		)
	)
)

(instance sLanaSits of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(lana setPri: 9)
				(if (< (lana x?) 51)
					(self changeState: 2)
				else
					(lana setLoop: 1 setMotion: MoveTo 50 145 self)
				)
			)
			(1
				(lana setLoop: 2 setCycle: ForwardCounter 2 self)
			)
			(2
				(lana
					setLoop: 3
					setCycle: End
					setMotion: MoveTo 93 145 self
				)
			)
			(3
				(lana
					setLoop: 4
					setCycle: Fwd
					setMotion: MoveTo 107 145 self
				)
			)
			(4
				(skater5 setPri: 9)
				(lana posn: (lana x?) 148 setLoop: 5 setCycle: End self)
			)
			(5 (self dispose:))
		)
	)
)

(instance sSitDown of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= pEventX (if register 90 else 142))
				(= pEventY 145)
				(= thePicView self)
				(= local11 0)
				(global2 setScript: sMoveLarry)
			)
			(1
				(if register
					(gLarry setMotion: MoveTo 90 149 self)
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					(gLarry
						view: 791
						setLoop: (if (gLarry skating?) 2 else 0)
						setCel: 0
						setCycle: End self
						sitting: 1
					)
				else
					(gLarry
						view: 791
						setLoop: 4
						setCel: 0
						setCycle: End self
						sitting: 1
					)
				)
			)
			(3 (self dispose:))
		)
	)
)

(instance sDoSkates of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gLarry skating?)
					(gLarry setLoop: 1 setCel: 255 setCycle: Beg self)
				else
					(proc0_10 3 139)
					(gLarry setLoop: 1 setCel: 0 setCycle: End self)
				)
			)
			(1
				(if (gLarry skating?)
					(gLarry skating: 0)
					(= local5 761)
					(= local6 764)
					((Inv at: 18) state: 0)
					(gLarry setLoop: 0 setCel: 255)
					(proc958_0 128 763 762 761 764)
				else
					(gLarry skating: 1)
					(= local5 765)
					(= local6 768)
					((Inv at: 18) state: 1)
					(gLarry setLoop: 2 setCel: 255)
					(proc958_0 128 767 766 765 768)
				)
				(self dispose:)
			)
		)
	)
)

(instance sStandUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (gLarry setCycle: Beg self))
			(1
				(gLarry
					sitting: 0
					normalize: local6
					setStep: 3 3
					setHeading: 0
					posn: (gLarry x?) 145
				)
				(if register (bench doVerb: 4 18))
				(self dispose:)
			)
		)
	)
)

(instance sMoveLarry of Script
	(properties)
	
	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gLarry normalize: (gLarry view?) setStep: 3 3)
				(cond 
					((< pEventY (- (gLarry y?) 5)) (= register 1))
					((> pEventY (+ (gLarry y?) 5)) (= register 2))
					(else (= register 0))
				)
				(= cycles 1)
			)
			(1
				(switch register
					(0
						(User canControl: 1)
						(++ state)
						(gLarry
							setCycle: StopWalk -1
							setMotion: PolyPath pEventX (proc999_2 145 (gLarry y?)) self
						)
					)
					(1
						(User canControl: 0)
						(if (== (gLarry view?) local5)
							(= register 0)
							(= cycles 1)
						else
							(= temp0 (- (gLarry view?) local5))
							(gLarry
								setLoop: 3
								setCel: 0
								setCycle: End
								setMotion: PolyPath (gLarry x?) [local12 temp0] self
							)
						)
					)
					(2
						(User canControl: 0)
						(if (== (gLarry view?) local6)
							(= register 0)
							(= cycles 1)
						else
							(= temp0 (- (gLarry view?) local5))
							(gLarry
								setLoop: 2
								setCel: 0
								setCycle: End
								setMotion: PolyPath (gLarry x?) [local16 temp0] self
							)
						)
					)
				)
			)
			(2
				(switch register
					(1
						(if (< (gLarry view?) 769)
							(gLarry
								view: (- (gLarry view?) 1)
								setLoop: -1
								setCel: 255
							)
						)
						(if (< (- (gLarry y?) pEventY) 6) (= register 0))
					)
					(2
						(if (< (gLarry view?) 769)
							(gLarry
								view: (+ (gLarry view?) 1)
								setLoop: -1
								setCel: 0
							)
						)
						(if (< (- pEventY (gLarry y?)) 6) (= register 0))
					)
				)
				(self changeState: 1)
			)
			(3
				(cond 
					(local11 (thePicView doVerb: local11))
					(thePicView (thePicView cue:))
				)
				(= thePicView (= local11 0))
				(User canControl: 1)
				(self dispose:)
			)
		)
	)
)

(instance sLanaTalks of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_18 gLarry 760 29)
				(= ticks 60)
			)
			(1
				(proc0_18 Lana_Luscious_ 760 30 108)
				(= ticks 60)
			)
			(2)
			(3
				(proc0_18 gLarry 760 31)
				(= ticks 60)
			)
			(4
				(proc0_18 Lana_Luscious_ 760 32 108)
				(= ticks 60)
			)
			(5)
			(6
				(proc0_18 gLarry 760 33)
				(= ticks 60)
			)
			(7
				(proc0_18 Lana_Luscious_ 760 34 108)
				(= ticks 60)
			)
			(8)
			(9
				(proc0_18 gLarry 760 35)
				(= ticks 60)
			)
			(10
				(proc0_18 Lana_Luscious_ 760 36 108)
				(= ticks 60)
			)
			(11
				(proc0_14 760 37 67 -1 185)
				(= ticks 60)
			)
			(12)
			(13
				(proc0_10 2 140)
				(proc0_18 gLarry 760 38)
				(= ticks 60)
			)
			(14
				(proc0_18 Lana_Luscious_ 760 39 108)
				(= ticks 60)
			)
			(15
				(proc0_14 760 40 67 -1 185)
				(= cycles 1)
			)
			(16
				(sMeetLana cue:)
				(self dispose:)
			)
		)
	)
)

(instance lanaFtr of Feature
	(properties
		x 160
		y 170
		nsBottom 189
		nsRight 319
		description {Lahodná Lana}
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2 (proc0_14 760 41))
			(5
				(if (global2 script?)
					((global2 script?) cue:)
				else
					(global2 setScript: sLanaTalks)
				)
			)
			(3
				(proc0_18 Lana_Luscious_ 760 42 108)
			)
			(10
				(proc0_18 Lana_Luscious_ 760 43 108)
			)
			(4
				(proc0_18 Lana_Luscious_ 760 44 108)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buildings of Feature
	(properties
		x 159
		y 29
		nsBottom 59
		nsRight 319
		description {budovy na promenádì}
		sightAngle 40
		lookStr {Vzdálená strana Trampovy promenády je lemována nevkusnými, lacinými turistickými pastmi. Skrz budovy vykukuje kousek modré oblohy.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 760 45))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance bench of Feature
	(properties
		x 126
		y 140
		nsTop 129
		nsLeft 98
		nsBottom 151
		nsRight 154
		description {lavièka}
		sightAngle 40
		approachX 88
		approachY 152
		lookStr {Dlouhá øada lavièek èeká na tvé potìšení z posezení podél strany promenády, u které je oceán.}
	)
	
	(method (doVerb theVerb param2 &tmp temp0)
		(switch theVerb
			(3
				(cond 
					((not (gLarry sitting?))
						(gLarry
							setScript: sSitDown 0 (if (sSitDown next:) 1 else 0)
						)
					)
					((== (gLarry loop?) 4) (gLarry setScript: sStandUp 0 (gLarry has: 18)))
					((gLarry has: 18) (gLarry setScript: sDoSkates))
					(else (super doVerb: theVerb param2 &rest))
				)
			)
			(4
				(if (== param2 18)
					(sSitDown next: sDoSkates)
					(self doVerb: 3)
				else
					(super doVerb: theVerb param2 &rest)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance post1 of Feature
	(properties
		x 61
		y 160
		nsTop 131
		nsLeft 51
		nsBottom 189
		nsRight 72
		description {sloup}
		sightAngle 40
		lookStr {Tyto sloupy drží promenádu.}
	)
)

(instance post2 of Feature
	(properties
		x 137
		y 163
		nsTop 138
		nsLeft 125
		nsBottom 189
		nsRight 149
		description {sloupek}
		sightAngle 40
		lookStr {Tyto sloupy drží promenádu.}
	)
)

(instance post3 of Feature
	(properties
		x 205
		y 164
		nsTop 139
		nsLeft 193
		nsBottom 189
		nsRight 221
		description {sloupek}
		sightAngle 40
		lookStr {Tyto sloupy drží promenádu.}
	)
)

(instance post4 of Feature
	(properties
		x 295
		y 165
		nsTop 141
		nsLeft 283
		nsBottom 189
		nsRight 309
		description {sloupek}
		sightAngle 40
		lookStr {Tyto sloupy drží promenádu.}
	)
)
